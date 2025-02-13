package net.parth.springboot.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MeetingRooms")
public class MeetingRoom {
  
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String buildingName;
    private int floorNo;
    private int capacity;
    private String meetingRoomName;
    
    @OneToMany(mappedBy = "meetingRoom", cascade = CascadeType.ALL)
    private List<Booking> bookings = new ArrayList<>();

    // Constructors
    public MeetingRoom() {
    }

    public MeetingRoom(String buildingName, int floorNo, int capacity,String meetingRoomName) {
        this.buildingName = buildingName;
        this.floorNo = floorNo;
        this.capacity = capacity;
        this.meetingRoomName = meetingRoomName;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

	public String getMeetingRoomName() {
		return meetingRoomName;
	}

	public void setMeetingRoomName(String meetingRoomName) {
		this.meetingRoomName = meetingRoomName;
	}
    
}

