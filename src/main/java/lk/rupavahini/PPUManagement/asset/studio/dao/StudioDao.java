package lk.rupavahini.PPUManagement.asset.studio.dao;


import lk.rupavahini.PPUManagement.asset.studio.entity.Studio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudioDao extends JpaRepository<Studio, Integer> {
    Studio findFirstByOrderByIdDesc();
}
