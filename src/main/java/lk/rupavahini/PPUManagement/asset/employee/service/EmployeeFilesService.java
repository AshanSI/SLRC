package lk.rupavahini.PPUManagement.asset.employee.service;


import lk.rupavahini.PPUManagement.asset.commonAsset.model.FileInfo;
import lk.rupavahini.PPUManagement.asset.employee.controller.EmployeeController;
import lk.rupavahini.PPUManagement.asset.employee.dao.EmployeeFilesDao;
import lk.rupavahini.PPUManagement.asset.employee.entity.Employee;
import lk.rupavahini.PPUManagement.asset.employee.entity.EmployeeFiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.stream.Collectors;
import java.util.*;

@Service
@CacheConfig(cacheNames = "employeeFiles")
public class EmployeeFilesService {
    private final EmployeeFilesDao employeeFilesDao;

    @Autowired
    public EmployeeFilesService(EmployeeFilesDao employeeFilesDao) {
        this.employeeFilesDao = employeeFilesDao;
    }

    public EmployeeFiles findByName(String filename) {
        return employeeFilesDao.findByName(filename);
    }

    public void persist(EmployeeFiles storedFile) {
        employeeFilesDao.save(storedFile);
    }


    public List<EmployeeFiles> search(EmployeeFiles employeeFiles) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<EmployeeFiles> employeeFilesExample = Example.of(employeeFiles, matcher);
        return employeeFilesDao.findAll(employeeFilesExample);
    }

    public EmployeeFiles findById(Integer id) {
        return employeeFilesDao.getOne(id);
    }

    public EmployeeFiles findByNewID(String filename) {
        return employeeFilesDao.findByNewId(filename);
    }

    @Cacheable
    public FileInfo employeeFileDownloadLinks(Employee employee) {

        List<EmployeeFiles> employeeFiles = employeeFilesDao.findByEmployeeOrderByIdDesc(employee);
        if (!employeeFiles.isEmpty()) {
            return new FileInfo(employeeFiles.get(0).getName(), employeeFiles.get(0).getCreatedAt(), MvcUriComponentsBuilder
                    .fromMethodName(EmployeeController.class, "downloadFile", employeeFiles.get(0).getNewId())
                    .build()
                    .toString());
        }
        return null;

    }
}
