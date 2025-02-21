package com.draysams.denhotel.service.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RoomReservation {
	private Long roomId;
	private String roomName;
	private String roomNumber;
	private long guestId;
	private String firstName;
	private String lastName;
	private long reservationId;
	private String reservationDate;
}
