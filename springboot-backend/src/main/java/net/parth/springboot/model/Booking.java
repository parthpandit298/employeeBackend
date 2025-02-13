package net.parth.springboot.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String meetingTitle;

    private String bookedBy; // userName (Email or Name)
    
    private LocalDate meetingDate;
    
    private LocalTime startTime;
    
    private LocalTime endTime;
    
    private String repeatBooking; // "none", "daily", "weekly", "monthly"
    
    @Column(length = 1000) // optional, to allow a longer description
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "meeting_room_id")
    private MeetingRoom meetingRoom;
    
    // Constructors
    public Booking() {
    }

    public Booking(String meetingTitle, String bookedBy, LocalDate meetingDate,
                   LocalTime startTime, LocalTime endTime,
                   String repeatBooking, String description,MeetingRoom meetingRoom)
                    {
        this.meetingTitle = meetingTitle;
        this.bookedBy = bookedBy;
        this.meetingDate = meetingDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.repeatBooking = repeatBooking;
        this.description = description;
        this.meetingRoom = meetingRoom;
    }
    
    

    // Getters and Setters (or use Lombok @Data / @Getter / @Setter)
    public Long getId() {
        return id;
    }

    public String getMeetingTitle() {
        return meetingTitle;
    }

    public void setMeetingTitle(String meetingTitle) {
        this.meetingTitle = meetingTitle;
    }

    public String getBookedBy() {
        return bookedBy;
    }

    public void setBookedBy(String bookedBy) {
        this.bookedBy = bookedBy;
    }

    public LocalDate getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(LocalDate meetingDate) {
        this.meetingDate = meetingDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getRepeatBooking() {
        return repeatBooking;
    }

    public void setRepeatBooking(String repeatBooking) {
        this.repeatBooking = repeatBooking;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public MeetingRoom getMeetingRoom() {
        return meetingRoom;
    }

    public void setMeetingRoom(MeetingRoom meetingRoom) {
        this.meetingRoom = meetingRoom;
    }
        
}
