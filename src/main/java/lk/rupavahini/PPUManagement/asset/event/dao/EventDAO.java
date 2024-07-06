package lk.rupavahini.PPUManagement.asset.event.dao;


import lk.rupavahini.PPUManagement.asset.event.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventDAO extends JpaRepository<Event,Long> {

    public List<Event> findByStartGreaterThanEqualAndFinishLessThanEqual(LocalDateTime start, LocalDateTime end);

    @Query("select e from Event e where e.eventtype='SingleDay' " )
    public List<Event> eventsone();

    @Query("select e from Event e where e.eventtype='BulkDays' " )
    public List<Event> eventsbulk();

    /* This one uses an @Query */
    @Query("select b from Event b where b.start >= ?1 and b.finish <= ?2")
    public List<Event> findByDateBetween(LocalDateTime start, LocalDateTime end);
//
//    @Query("select b from Event b where b.start between ?1 and ?2 and b.end between ?1 and ?2")
//    List<Event> findByDatesBetween(Date start, Date end);
}
