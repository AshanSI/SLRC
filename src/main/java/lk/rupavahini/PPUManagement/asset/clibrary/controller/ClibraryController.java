package lk.rupavahini.PPUManagement.asset.clibrary.controller;

import lk.rupavahini.PPUManagement.asset.clibrary.dao.ClibraryDao;
import lk.rupavahini.PPUManagement.asset.clibrary.entity.Clibrary;
import lk.rupavahini.PPUManagement.asset.clibrary.entity.Clibrary;
import lk.rupavahini.PPUManagement.util.interfaces.AbstractService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig( cacheNames = "clibrary" )
public class ClibraryController implements AbstractService<Clibrary, Integer> {
    private final ClibraryDao clibrarydao;

    public ClibraryController(ClibraryDao clibrarydao) {
        this.clibrarydao = clibrarydao;
    }

    public List<Clibrary> findAll() {
        return clibrarydao.findAll();
    }

    public Clibrary findById(Integer id) {
        return clibrarydao.getOne(id);
    }

    public Clibrary persist(Clibrary clibrary) {
        return clibrarydao.save(clibrary);
    }

    public boolean delete(Integer id) {
        clibrarydao.deleteById(id);
        return false;
    }

    public List<Clibrary> search(Clibrary clibrary) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Clibrary> ClibraryExample = Example.of(clibrary, matcher);
        return clibrarydao.findAll(ClibraryExample);
    }

    public Clibrary lastClibrary(){
        return clibrarydao.findFirstByOrderByIdDesc();
    }
}
