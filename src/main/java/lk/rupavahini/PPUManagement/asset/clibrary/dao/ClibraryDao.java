package lk.rupavahini.PPUManagement.asset.clibrary.dao;


import lk.rupavahini.PPUManagement.asset.clibrary.entity.Clibrary;
import lk.rupavahini.PPUManagement.asset.studio.entity.Studio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClibraryDao extends JpaRepository<Clibrary, Integer> {
    Clibrary findFirstByOrderByIdDesc();
}
