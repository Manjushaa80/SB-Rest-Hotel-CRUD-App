package com.app.service;

import java.util.List;

import com.app.model.Booking;
import com.app.model.Room;


public interface BookingService {

	Booking saveBooking(Booking booking);

	Booking getBooking(Long id);

	List<Booking> getBookings();

	Boolean deleteBooking(Long id);

	Booking updateBooking(Long id, Booking booking);

	Booking editBooking(Long id, Booking booking);

	
	

	

	
	

}
