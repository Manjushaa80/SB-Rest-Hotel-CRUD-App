package com.app.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.model.Room;
import com.app.repository.RoomRepository;
import com.app.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {
	private RoomRepository roomRepository;

	public RoomServiceImpl(RoomRepository roomRepository) {
		super();
		this.roomRepository = roomRepository;
	}

	@Override
	public Room saveRoom(Room room) {
		return roomRepository.save(room);

	}
	/*
	 * @Override public Room getRoom(int id) { if(roomRepository.existsById((long)
	 * id)) { return roomRepository.findById((long)id).get(); }
	 * 
	 * return null; }
	 */

	@Override
	public List<Room> getAllRooms() {

		return roomRepository.findAll();
	}

	@Override
	public Room getRoom(long id) {

		Optional<Room> optional = roomRepository.findById(id);
		if(optional.isPresent())
		{
			return roomRepository.findById(id).get();
		}
	     
		return null;
	}
@Override
public List<Room> deleteRoom(Long id) {

	if(roomRepository.existsById(id))
	{
           roomRepository.deleteById(id);
	    return getAllRooms();
     }
	return null;
	
}
@Override
public Room updateRoom(Long id, Room room) {
	if(roomRepository.existsById(id))
	{
		room.setId(id);
		return roomRepository.save(room);
	}
	return null;
}

@Override
public Room editRoom(Long id, Room room) {
	      if(roomRepository.existsById(id))
	      {
	    	  Room rm = roomRepository.findById(id).get();
	    	  if(room.getRoomNumber()!=null)
	    	  {
	    		  rm.setRoomNumber(room.getRoomNumber());
	    	  }
	    	  if(room.getPrice()!=null)
	    	  {
	    		  rm.setPrice(room.getPrice());
	    	  }
	    	  if(room.getType()!=null)
	    	  {
	    		  rm.setType(room.getType());
	    	  }
	    	  if(room.isAvailable())
	    	  {
	    		  rm.setAvailable(room.isAvailable());
	    	  }
	    	  Room room2 = roomRepository.save(rm);
	    	  return room2;
	    	  
	      }
	return null;
}




}