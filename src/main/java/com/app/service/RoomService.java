package com.app.service;

import java.util.List;

import com.app.model.Room;

public interface RoomService {

	Room saveRoom(Room room);

	List<Room> getAllRooms();

	

	Room getRoom(long id);

	List<Room> deleteRoom(Long id);

	Room updateRoom(Long id, Room room);

	Room editRoom(Long id, Room room);

	
	

	
}
