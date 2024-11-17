package com.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Booking;
import com.app.model.Room;
import com.app.service.BookingService;


@RestController
@RequestMapping(value = "api/v1")
public class BookingController {

	private BookingService bookingService;

	@Autowired
	public void setBookingService(BookingService bookingService) {
		this.bookingService = bookingService;
	}
	
	@PostMapping(value = "/bookings")
	public ResponseEntity<Booking> saveBooking(@RequestBody Booking booking)
	{
		Booking bk =bookingService.saveBooking(booking);
		return new ResponseEntity<Booking>(bk, HttpStatus.OK);
		
	}
	@GetMapping(value = "/bookings")
	public ResponseEntity<List<Booking>>getBookings()
	{ 
		List<Booking> blist=bookingService.getBookings();
		return new ResponseEntity<List<Booking>>(blist, HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/bookings/{id}")
	public ResponseEntity<Booking> getBooking(@PathVariable Long id)
	{
		Booking bk =bookingService.getBooking(id);
		
		if(bk!=null) {
			return new ResponseEntity<Booking>(bk, HttpStatus.OK);
				
			}
		return new ResponseEntity<Booking>(bk, HttpStatus.NOT_FOUND);
		}
	
	@DeleteMapping(value = "/bookings/{id}")
	public ResponseEntity<Void> deleteBooking(@PathVariable Long id )
	{
		
		Boolean b=bookingService.deleteBooking(id);
		if(b!=null)
		{
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	@PutMapping(value = "/bookings/{id}")
	public ResponseEntity<Booking> updateRoom(@PathVariable Long id, @RequestBody Booking booking) {
		Booking b = bookingService.updateBooking(id, booking);
		return new ResponseEntity<Booking>(b, HttpStatus.OK);
	}

	@PatchMapping(value = "/booking/{id}")
	public ResponseEntity<Booking> editRoom(@PathVariable Long id, @RequestBody Booking booking)
	{
		Booking b =bookingService.editBooking(id,booking);
		return new ResponseEntity<Booking>(b, HttpStatus.OK);
	}
	
}
	

