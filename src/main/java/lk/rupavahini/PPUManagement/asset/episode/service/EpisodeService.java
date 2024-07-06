package lk.rupavahini.PPUManagement.asset.episode.service;
import lk.rupavahini.PPUManagement.asset.episode.dao.EpisodeDao;
import lk.rupavahini.PPUManagement.asset.episode.entty.Episode;
import lk.rupavahini.PPUManagement.util.interfaces.AbstractService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@CacheConfig(cacheNames = "episode")
public class EpisodeService implements AbstractService<Episode, Integer> {
    private final EpisodeDao episodeDao;

    public EpisodeService(EpisodeDao episodeDao) {
        this.episodeDao = episodeDao;
    }


    public List<Episode> findAll() {
        return episodeDao.findAll();
    }

    public Episode findById(Integer id) {
        return episodeDao.getOne(id);
    }

    public Episode persist(Episode episode) {
        return episodeDao.save(episode);
    }

    public boolean delete(Integer id) {
        episodeDao.deleteById(id);
        return false;
    }

    public List<Episode> search(Episode episode) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Episode> SponserExample = Example.of(episode, matcher);
        return episodeDao.findAll(SponserExample);
    }

    public Episode lastEpisode(){
        return episodeDao.findFirstByOrderByIdDesc();
    }
}
