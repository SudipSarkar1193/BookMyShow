package services;

import enums.BookingStatus;
import models.booking.Booking;
import models.theatre.Seat;
import models.theatre.Show;

import java.util.ArrayList;
import java.util.List;

public class BookingService {
    private List<Booking> bookings;

    public BookingService() {
        this.bookings = new ArrayList<>();
    }

    public Booking createBooking(int userId, Show show, List<Seat> selectedSeats) {
        // Validate: Ensure seats are part of the show’s screen
        if (!show.getScreen().getSeats().containsAll(selectedSeats)) {
            throw new IllegalArgumentException("Selected seats are not part of the show’s screen");
        }

        // Validate: Check seat availability (simplified, assumes seats are available)
        // In a real system, check if seats are already booked
        for (Booking existingBooking : bookings) {
            if (existingBooking.getShow().getShowId() == show.getShowId() &&
                existingBooking.getStatus() != BookingStatus.Cancelled &&
                !existingBooking.getSeats().stream().noneMatch(selectedSeats::contains)) {
                throw new IllegalArgumentException("Some seats are already booked");
            }
        }

        // Calculate total price
        double totalPrice = selectedSeats.stream()
                                        .mapToDouble(seat -> seat.getCategory().getPrice())
                                        .sum();

        // Create booking
        Booking booking = new Booking(bookings.size() + 1, userId, show, selectedSeats, totalPrice);
        booking.setStatus(BookingStatus.Confirmed); // Assume instant confirmation
        bookings.add(booking);

        return booking;
    }

    public List<Booking> getBookingsByUser(int userId) {
        List<Booking> userBookings = new ArrayList<>();
        for (Booking booking : bookings) {
            if (booking.getUserId() == userId) {
                userBookings.add(booking);
            }
        }
        return userBookings;
    }
}