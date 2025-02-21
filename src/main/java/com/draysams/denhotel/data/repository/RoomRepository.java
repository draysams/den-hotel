package com.draysams.denhotel.data.repository;

import java.util.Optional;

import com.draysams.denhotel.data.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
	Optional<Room> findByRoomNumberIgnoreCase(String roomNumber);
}
