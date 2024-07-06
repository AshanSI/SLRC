package lk.rupavahini.PPUManagement.asset.episode.dao;


import lk.rupavahini.PPUManagement.asset.episode.entty.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpisodeDao extends JpaRepository<Episode, Integer> {
    Episode findFirstByOrderByIdDesc();
}
