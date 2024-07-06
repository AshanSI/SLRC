package lk.rupavahini.PPUManagement.asset.programme.service;




import lk.rupavahini.PPUManagement.asset.programme.dao.ProgrammeDao;
import lk.rupavahini.PPUManagement.asset.programme.entity.Programme;
import lk.rupavahini.PPUManagement.util.interfaces.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
// spring transactional annotation need to tell spring to this method work through the project
@CacheConfig(cacheNames = "programme")
public class ProgrammeService implements AbstractService <Programme, Integer> {

    private final ProgrammeDao programmeDao;

    @Autowired
    public ProgrammeService(ProgrammeDao programmeDao) {
        this.programmeDao = programmeDao;
    }

    @Cacheable
    public List<Programme> findAll() {
        return programmeDao.findAll();
    }

    @Cacheable
    public Programme findById(Integer id) {
        return programmeDao.getOne(id);
    }

    @Caching(evict = {@CacheEvict(value = "programme", allEntries = true)},
            put = {@CachePut(value = "programme", key = "#programme.id")})
    @Transactional
    public Programme persist(Programme programme) {
        return programmeDao.save(programme);
    }

    @CacheEvict(allEntries = true)
    public boolean delete(Integer id) {
        programmeDao.deleteById(id);
        return false;
    }

    @Cacheable
    public List<Programme> search(Programme programme) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Programme> programmeExample = Example.of(programme, matcher);
        return programmeDao.findAll(programmeExample);
    }

    public boolean isProgrammePresent(Programme programme) {
        return programmeDao.equals(programme);
    }


    public Programme lastProgramme() {
        return programmeDao.findFirstByOrderByIdDesc();
    }

}
