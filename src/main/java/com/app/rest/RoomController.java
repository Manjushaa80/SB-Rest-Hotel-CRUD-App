package com.app.rest;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Room;
import com.app.service.RoomService;

@RestController
@RequestMapping(value = "/api/v1")
public class RoomController {

	private RoomService roomService;

	public RoomController(RoomService roomService) {
		super();
		this.roomService = roomService;
	}

	@PostMapping(value = "/rooms", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<Room> saveRoom(@RequestBody Room room) {
		Room rm = roomService.saveRoom(room);
		return new ResponseEntity<Room>(rm, HttpStatus.CREATED);

	}

	@GetMapping(value = "/rooms/{id}", produces = { "application/json" })
	public ResponseEntity<Room> getRoom(@PathVariable long id) {

		Room rm = roomService.getRoom(id);
		return new ResponseEntity<Room>(rm, HttpStatus.OK);
	}

	@GetMapping(value = "/rooms", consumes = { "application/json" })
	public ResponseEntity<List<Room>> getAllRooms() {

		List<Room> rm = roomService.getAllRooms();
		return new ResponseEntity<List<Room>>(rm, HttpStatus.OK);
	}

	@DeleteMapping(value = "/rooms/{id}")
	public ResponseEntity<List<Room>> deleteRoom(@PathVariable Long id) {
		roomService.deleteRoom(id);
		return new ResponseEntity<List<Room>>(HttpStatus.OK);

	}

	@PutMapping(value = "/rooms/{id}")
	public ResponseEntity<Room> updateRoom(@PathVariable Long id, @RequestBody Room room) {
		Room rm = roomService.updateRoom(id, room);
		return new ResponseEntity<Room>(rm, HttpStatus.OK);
	}

	@PatchMapping(value = "/rooms/{id}")
	public ResponseEntity<Room> editRoom(@PathVariable Long id, @RequestBody Room room)
	{
		Room rm =roomService.editRoom(id,room);
		return new ResponseEntity<Room>(rm, HttpStatus.OK);
	}
	
	
}
