package lk.rupavahini.PPUManagement.asset.booking.service;


import lk.rupavahini.PPUManagement.asset.booking.dao.BookingDao;
import lk.rupavahini.PPUManagement.asset.booking.entity.Booking;
import lk.rupavahini.PPUManagement.util.interfaces.AbstractService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig( cacheNames = "booking" )
public class BookingService implements AbstractService<Booking, Integer> {
    private final BookingDao bookingDao;

    public BookingService(BookingDao Bookingdao) {
        this.bookingDao = Bookingdao;
    }


    public List<Booking> findAll() {
        return bookingDao.findAll();
    }

    public Booking findById(Integer id) {
        return bookingDao.getOne(id);
    }

    public Booking persist(Booking booking) {
        return bookingDao.save(booking);
    }

    public boolean delete(Integer id) {
        bookingDao.deleteById(id);
        return false;
    }

    public List<Booking> search(Booking Booking) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Booking> BookingExample = Example.of(Booking, matcher);

        return bookingDao.findAll(BookingExample);
    }
    public Booking lastBooking(){
        return bookingDao.findFirstByOrderByIdDesc();
    }
}
