package com.draysams.denhotel.data.repository;

import java.util.Optional;

import com.draysams.denhotel.data.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
	Optional<Guest> findByEmailAddress(String email);
}
