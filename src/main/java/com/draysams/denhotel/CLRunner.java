package com.draysams.denhotel;

import java.util.List;
import java.util.Optional;

import com.draysams.denhotel.data.entity.Guest;
import com.draysams.denhotel.data.entity.Reservation;
import com.draysams.denhotel.data.entity.Room;
import com.draysams.denhotel.data.repository.GuestRepository;
import com.draysams.denhotel.data.repository.ReservationRepository;
import com.draysams.denhotel.data.repository.RoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CLRunner implements CommandLineRunner {
	
	private final RoomRepository roomRepository;
	private final ReservationRepository reservationRepository;
	private final GuestRepository guestRepository;
	
	public CLRunner(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository) {
		this.roomRepository = roomRepository;
		this.reservationRepository = reservationRepository;
		this.guestRepository = guestRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		List<Room> rooms = this.roomRepository.findAll();
		Optional<Room> room = this.roomRepository.findByRoomNumberIgnoreCase("p1");
		System.out.println(room);
		rooms.forEach(System.out::println);
		
		System.out.println("**** GUESTS ****");
		List<Guest> guests = this.guestRepository.findAll();
		guests.forEach(System.out::println);
		
		System.out.println("**** RESERVATIONS****");
		List<Reservation> reservations = this.reservationRepository.findAll();
		reservations.forEach(System.out::println);
 	}
}

