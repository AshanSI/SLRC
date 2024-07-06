package lk.rupavahini.PPUManagement.asset.event.service;


import lk.rupavahini.PPUManagement.asset.event.dao.EventDAO;
import lk.rupavahini.PPUManagement.asset.event.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventDAO eventDAO;

    public List<Event> events() {
        return eventDAO.findAll();
    }

    @Override
    public List<Event> eventsone() {
        return eventDAO.eventsone();
    }

    @Override
    public List<Event> eventsbulk() {
        return eventDAO.eventsbulk();
    }

    @Override
    public List<Event> findByDatesBetween(Date start, Date end) {
//        return eventDAO.findByDatesBetween(start,end);
        return null;
    }

    @Override
    public List<Event> findByDateBetween(LocalDateTime start, LocalDateTime end) {
        return eventDAO.findByDateBetween(start,end);
    }

    @Override
    public Event save(Event event) {
        return eventDAO.save(event);
    }

    @Override
    public Event update(Event event) {
        Event data_not_found=null;
        try {
            data_not_found = eventDAO.findById(event.getId()).orElseThrow(() -> new Exception("Data not Found"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (data_not_found==null){
            return null;
        }else{
            return eventDAO.save(event);
        }
    }

    @Override
    public boolean delete(long id) {
        Event data_not_found=null;
        try {
            data_not_found = eventDAO.findById(id).orElseThrow(() -> new Exception("Data not Found"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (data_not_found==null){
            return false;
        }else{
             eventDAO.delete(data_not_found);
             return true;
        }
    }
}
