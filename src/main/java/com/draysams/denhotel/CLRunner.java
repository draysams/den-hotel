package com.draysams.denhotel;

import java.util.List;
import java.util.Optional;

import com.draysams.denhotel.data.entity.Room;
import com.draysams.denhotel.data.repository.RoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CLRunner implements CommandLineRunner {
	
	private final RoomRepository roomRepository;

	public CLRunner(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		List<Room> rooms = this.roomRepository.findAll();
		Optional<Room> room = this.roomRepository.findByRoomNumberIgnoreCase("p1");
		System.out.println(room);
		rooms.forEach(System.out::println);
 	}
}

