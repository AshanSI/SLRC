package lk.rupavahini.PPUManagement.asset.sponsor.dao;


import lk.rupavahini.PPUManagement.asset.sponsor.entity.Sponsor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SponsorDao extends JpaRepository<Sponsor, Integer> {
    Sponsor findFirstByOrderByIdDesc();
}
