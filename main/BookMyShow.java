import models.booking.Booking;
import models.theatre.Seat;
import models.theatre.Show;
import enums.BookingStatus;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void BookMyShow (String[] args) {
        // Creating sample Show object
        Show show = new Show(1, "Avengers: Endgame", "2025-05-15 19:00");

        // Creating sample Seat objects
        Seat seat1 = new Seat(1, 1, "A1");
        Seat seat2 = new Seat(1, 2, "A2");
        List<Seat> seats = Arrays.asList(seat1, seat2);

        // Creating Booking object with test data
        Booking booking = new Booking(101, 2001, show, seats, 50.00);

        // Displaying booking details
        System.out.println("Booking ID: " + booking.getBookingId());
        System.out.println("User ID: " + booking.getUserId());
        System.out.println("Show: " + booking.getShow().getTitle() + " at " + booking.getShow().getTime());
        System.out.println("Seats: ");
        for (Seat seat : booking.getSeats()) {
            System.out.println("  - " + seat.getSeatNumber());
        }
        System.out.println("Total Price: " + booking.getTotalPrice());
        System.out.println("Booking Status: " + booking.getStatus());

        // Updating and displaying the booking status
        booking.setStatus(BookingStatus.Confirmed);
        System.out.println("Updated Booking Status: " + booking.getStatus());
    }
}
