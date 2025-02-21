package com.draysams.denhotel.data.repository;

import java.sql.Date;
import java.util.List;

import com.draysams.denhotel.data.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	List<Reservation> findAllByReservationDate(Date date);

}
