package lk.rupavahini.PPUManagement.asset.sponsor.service;

import lk.rupavahini.PPUManagement.asset.sponsor.dao.SponsorDao;
import lk.rupavahini.PPUManagement.asset.sponsor.entity.Sponsor;
import lk.rupavahini.PPUManagement.util.interfaces.AbstractService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig( cacheNames = "sponsor" )
public class SponsorService implements AbstractService<Sponsor, Integer> {
    private final SponsorDao sponsorDao;

    public SponsorService(SponsorDao sponsorDao) {
        this.sponsorDao = sponsorDao;
    }

    public List<Sponsor> findAll() {
        return sponsorDao.findAll();
    }

    public Sponsor findById(Integer id) {
        return sponsorDao.getOne(id);
    }

    public Sponsor persist(Sponsor sponsor) {
        return sponsorDao.save(sponsor);
    }

    public boolean delete(Integer id) {
        sponsorDao.deleteById(id);
        return false;
    }

    public List<Sponsor> search(Sponsor sponsor) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Sponsor> SponsorExample = Example.of(sponsor, matcher);
        return sponsorDao.findAll(SponsorExample);
    }

    public Sponsor lastSponsor(){
        return sponsorDao.findFirstByOrderByIdDesc();
    }
}
