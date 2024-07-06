package lk.rupavahini.PPUManagement.asset.event.service;



import lk.rupavahini.PPUManagement.asset.event.entity.Event;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface EventService {

    public List<Event> events() ;
    public List<Event> eventsone() ;
    public List<Event> eventsbulk() ;
    List<Event> findByDatesBetween(Date start, Date end);
    public List<Event> findByDateBetween(LocalDateTime start, LocalDateTime end);
    public Event save(Event event);
    public Event update(Event event);
    public boolean delete(long id);
}
