package lk.rupavahini.PPUManagement.asset.programme.dao;




import lk.rupavahini.PPUManagement.asset.programme.entity.Programme;
import lk.rupavahini.PPUManagement.asset.programme.entity.Programme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProgrammeDao extends JpaRepository<Programme, Integer> {
    Programme findFirstByOrderByIdDesc();

}
