package com.draysams.denhotel.data.entity;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "reservations")
@Data
@ToString
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "reservation_id")
	private Long id;
	@Column(name = "room_id")
	private Long roomId;
	@Column(name = "guest_id")
	private Long guestId;
	@Column(name = "res_date")
	private Date reservationDate;
}
