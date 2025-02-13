package net.parth.springboot.controller;



import net.parth.springboot.model.Booking;
import net.parth.springboot.repository.BookingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found with id: " + id));
    }
    
    @GetMapping("/room/{roomId}")
    public List<Booking> getBookingsByRoomId(@PathVariable Long roomId) {
        return bookingRepository.findAll()
                .stream()
                .filter(booking -> booking.getMeetingRoom() != null 
                    && booking.getMeetingRoom().getId().equals(roomId))
                .toList();
    }

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingRepository.save(booking);
    }

    @PutMapping("/{id}")
    public Booking updateBooking(@PathVariable Long id, @RequestBody Booking updatedBooking) {
        // orElseThrow -> handle exception if booking not found
        Booking existingBooking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found with id: " + id));

        existingBooking.setMeetingTitle(updatedBooking.getMeetingTitle());
        existingBooking.setBookedBy(updatedBooking.getBookedBy());
        existingBooking.setMeetingDate(updatedBooking.getMeetingDate());
        existingBooking.setStartTime(updatedBooking.getStartTime());
        existingBooking.setEndTime(updatedBooking.getEndTime());
        existingBooking.setRepeatBooking(updatedBooking.getRepeatBooking());
        existingBooking.setDescription(updatedBooking.getDescription());

        return bookingRepository.save(existingBooking);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id) {
        bookingRepository.deleteById(id);
    }
}

