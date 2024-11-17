package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<com.app.model.Booking, Long> 
{
	

}
