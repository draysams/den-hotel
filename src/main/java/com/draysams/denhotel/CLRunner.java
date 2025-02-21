package com.draysams.denhotel;

import java.util.List;
import java.util.Optional;

import com.draysams.denhotel.data.entity.Guest;
import com.draysams.denhotel.data.entity.Reservation;
import com.draysams.denhotel.data.entity.Room;
import com.draysams.denhotel.data.repository.GuestRepository;
import com.draysams.denhotel.data.repository.ReservationRepository;
import com.draysams.denhotel.data.repository.RoomRepository;
import com.draysams.denhotel.service.RoomReservationService;
import com.draysams.denhotel.service.model.RoomReservation;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CLRunner implements CommandLineRunner {
	
	private final RoomRepository roomRepository;
	private final ReservationRepository reservationRepository;
	private final GuestRepository guestRepository;
	private final RoomReservationService roomReservationService;
	
	public CLRunner(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository, RoomReservationService roomReservationService) {
		this.roomRepository = roomRepository;
		this.reservationRepository = reservationRepository;
		this.guestRepository = guestRepository;
		this.roomReservationService = roomReservationService;
	}
	
	@Override
	public void run(String... args) throws Exception {
		List<RoomReservation> reservations = this.roomReservationService.getRoomReservationsForDate("2023-08-28");
 		reservations.forEach(System.out::println);
	}
}

