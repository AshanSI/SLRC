package lk.rupavahini.PPUManagement.asset.studio.service;


import lk.rupavahini.PPUManagement.asset.studio.dao.StudioDao;
import lk.rupavahini.PPUManagement.asset.studio.entity.Studio;
import lk.rupavahini.PPUManagement.util.interfaces.AbstractService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig( cacheNames = "studio" )
public class StudioService implements AbstractService<Studio, Integer> {
    private final StudioDao studiodao;

    public StudioService(StudioDao studiodao) {
        this.studiodao = studiodao;
    }


    public List<Studio> findAll() {
        return studiodao.findAll();
    }

    public Studio findById(Integer id) {
        return studiodao.getOne(id);
    }

    public Studio persist(Studio studio) {
        return studiodao.save(studio);
    }

    public boolean delete(Integer id) {
        studiodao.deleteById(id);
        return false;
    }

    public List<Studio> search(Studio Studio) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Studio> SponserExample = Example.of(Studio, matcher);
        return studiodao.findAll(SponserExample);
    }

    public Studio lastStudio(){
        return studiodao.findFirstByOrderByIdDesc();
    }
}
