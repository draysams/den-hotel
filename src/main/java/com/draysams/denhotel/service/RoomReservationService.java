package com.draysams.denhotel.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import ch.qos.logback.core.util.StringUtil;
import com.draysams.denhotel.data.entity.Guest;
import com.draysams.denhotel.data.entity.Reservation;
import com.draysams.denhotel.data.entity.Room;
import com.draysams.denhotel.data.repository.GuestRepository;
import com.draysams.denhotel.data.repository.ReservationRepository;
import com.draysams.denhotel.data.repository.RoomRepository;
import com.draysams.denhotel.service.model.RoomReservation;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class RoomReservationService {
	private final GuestRepository guestRepository;
	private final RoomRepository roomRepository;
	private final ReservationRepository reservationRepository;
	
	
	public RoomReservationService(GuestRepository guestRepository, RoomRepository roomRepository,
			ReservationRepository reservationRepository) {
		this.guestRepository = guestRepository;
		this.roomRepository = roomRepository;
		this.reservationRepository = reservationRepository;
	}
	
	public List<RoomReservation> getRoomReservationsForDate(String reservationDate) {
		java.sql.Date date = null;
		if (StringUtils.isNotEmpty(reservationDate)) {
			date = java.sql.Date.valueOf(reservationDate);
		} else {
			date = new java.sql.Date(new Date().getTime());
		}
		Map<Long, RoomReservation> roomReservations = new HashMap<>();
		List<Room> rooms = roomRepository.findAll();
		
		rooms.forEach(room -> {
			RoomReservation roomReservation = new RoomReservation();
			roomReservation.setRoomId(room.getId());
			roomReservation.setRoomName(room.getName());
			roomReservation.setRoomNumber(room.getRoomNumber());
			roomReservations.put(roomReservation.getRoomId(), roomReservation);
		});
		List<Reservation> reservations = this.reservationRepository.findAllByReservationDate(date);
		
		reservations.forEach(reservation -> {
			RoomReservation roomReservation = roomReservations.get(reservation.getRoomId());
			roomReservation.setReservationId(reservation.getId());
			roomReservation.setReservationDate((reservation.getReservationDate().toString()));
			Optional<Guest> guest = guestRepository.findById(reservation.getGuestId());
			roomReservation.setGuestId(guest.get().getId());
			roomReservation.setFirstName(guest.get().getFirstName());
			roomReservation.setLastName(guest.get().getLastName());
		});
		
		return roomReservations.values().stream().toList();
	}
}
