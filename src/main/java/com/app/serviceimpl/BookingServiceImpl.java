package com.app.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.model.Booking;
import com.app.model.Room;
import com.app.repository.BookingRepository;

import com.app.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService

{
	private BookingRepository bookingRepository;

	public BookingServiceImpl(BookingRepository bookingRepository) {
		super();
		this.bookingRepository = bookingRepository;
	}
	@Override
	public Booking saveBooking(Booking booking) {
		
		return bookingRepository.save(booking);
	}
	
	@Override
	public Booking getBooking(Long id) {
		 Optional<Booking> optional = bookingRepository.findById(id);
		 if(optional.isPresent())
		 {
			 return bookingRepository.findById(id).get();
		 }
		return null;
	}
	
	@Override
	public List<Booking> getBookings() {
		
		return bookingRepository.findAll();
	}
@Override
	public Boolean deleteBooking(Long id) {
		if(bookingRepository.existsById(id))
		{
			bookingRepository.deleteById(id);
			return true;
		}
		return null;
	}

@Override
public Booking updateBooking(Long id, Booking booking) {
	if(bookingRepository.existsById(id)) {
	return bookingRepository.save(booking);
}
	return null;
}
@Override
public Booking editBooking(Long id, Booking booking) {
	if(bookingRepository.existsById(id))
	{
		Booking exittingbooking = bookingRepository.findById(id).get();
		if(booking.getCustomerName()!=null)
		{
			exittingbooking.setCustomerName(booking.getCustomerName());
		}
		if(booking.getCheckInDate()!=null)
		{
			exittingbooking.setCheckInDate(booking.getCheckInDate());
		}
		if(booking.getCheckOutDate()!=null)
		{
			exittingbooking.setCheckOutDate(booking.getCheckInDate());
		}
		if(booking.getRoomId()!=null)
		{
			exittingbooking.setRoomId(booking.getRoomId());
		} 
		Booking bk = bookingRepository.save(exittingbooking);
		return bk;
	}
	return null;
}
}

