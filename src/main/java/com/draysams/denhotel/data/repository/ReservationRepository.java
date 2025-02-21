package com.draysams.denhotel.data.repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import com.draysams.denhotel.data.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	Optional<Reservation> findAllByReservationDate(Date date);

}
