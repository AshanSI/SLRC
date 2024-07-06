package lk.rupavahini.PPUManagement.asset.booking.dao;


import lk.rupavahini.PPUManagement.asset.booking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingDao extends  JpaRepository<Booking, Integer> {

    Booking findFirstByOrderByIdDesc();
}
