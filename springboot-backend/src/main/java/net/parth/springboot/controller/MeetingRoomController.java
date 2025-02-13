package net.parth.springboot.controller;

import net.parth.springboot.model.MeetingRoom;
import net.parth.springboot.repository.MeetingRoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/meeting-rooms")
public class MeetingRoomController {

    private final MeetingRoomRepository meetingRoomRepository;

    @Autowired
    public MeetingRoomController(MeetingRoomRepository meetingRoomRepository) {
        this.meetingRoomRepository = meetingRoomRepository;
    }

    /**
     * Get all meeting rooms.
     *
     * @return a list of all meeting rooms
     */
    @GetMapping
    public List<MeetingRoom> getAllMeetingRooms() {
        return meetingRoomRepository.findAll();
    }

    /**
     * Get a meeting room by its ID.
     *
     * @param id the ID of the meeting room
     * @return the meeting room if found, otherwise null or handle the not found scenario
     */
    @GetMapping("/{id}")
    public MeetingRoom getMeetingRoomById(@PathVariable Long id) {
        return meetingRoomRepository.findById(id).orElse(null);
    }

    /**
     * Create a new meeting room.
     *
     * @param meetingRoom the data for the new meeting room
     * @return the created meeting room
     */
    @PostMapping
    public MeetingRoom createMeetingRoom(@RequestBody MeetingRoom meetingRoom) {
        return meetingRoomRepository.save(meetingRoom);
    }

    /**
     * Update an existing meeting room.
     *
     * @param id          the ID of the meeting room to update
     * @param meetingRoom the updated data
     * @return the updated meeting room if it exists, otherwise null or handle not found
     */
    @PutMapping("/{id}")
    public MeetingRoom updateMeetingRoom(@PathVariable Long id, @RequestBody MeetingRoom meetingRoom) {
        Optional<MeetingRoom> existingRoomOpt = meetingRoomRepository.findById(id);
        if (existingRoomOpt.isPresent()) {
            MeetingRoom existingRoom = existingRoomOpt.get();
            existingRoom.setBuildingName(meetingRoom.getBuildingName());
            existingRoom.setFloorNo(meetingRoom.getFloorNo());
            existingRoom.setCapacity(meetingRoom.getCapacity());
            return meetingRoomRepository.save(existingRoom);
        } else {
            // Handle not found scenario
            return null;
        }
    }

    /**
     * Delete a meeting room by its ID.
     *
     * @param id the ID of the meeting room to delete
     */
    @DeleteMapping("/{id}")
    public void deleteMeetingRoom(@PathVariable Long id) {
        meetingRoomRepository.deleteById(id);
    }
}
