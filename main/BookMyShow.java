package main;

import enums.City;
import enums.SeatCategory;
import models.movies.Movie;
import models.theatre.Screen;
import models.theatre.Seat;
import models.theatre.Show;
import models.theatre.Theatre;
import services.BookingService;
import services.ShowService;
import services.TheatreService;
import java.time.LocalDateTime;
import java.util.Arrays;
import models.booking.Booking; // Ensure this import

public class BookMyShow {

    public static void main(String[] args) {
        System.out.println("Welcome to TicketMaster! Application started successfully.");

        // Test Step 5: Test BookingService
        // Create services
        TheatreService theatreService = new TheatreService();
        ShowService showService = new ShowService();
        BookingService bookingService = new BookingService();

        // Create a Movie
        Movie movie = new Movie(1, "Joker", 132);

        // Create a Theatre
        Theatre theatre = new Theatre(1, "PVR Cinemas", City.Kalyani);
        theatreService.addTheatre(theatre);

        // Create a Screen
        Screen screen = new Screen(1, "Screen 1");
        theatre.addScreen(screen);

        // Create Seats
        Seat seat1 = new Seat(1, 1, 1, SeatCategory.Platinum);
        Seat seat2 = new Seat(2, 1, 2, SeatCategory.Gold);
        screen.addSeat(seat1);
        screen.addSeat(seat2);

        // Create a Show
        Show show = new Show(1, movie, screen, LocalDateTime.now(), movie.getMovieDuration());
        showService.addShow(theatre, screen, show);

        // Test BookingService: Create a booking
        int userId = 101;
        Booking booking = bookingService.createBooking(userId, show, Arrays.asList(seat1, seat2));

        // Print booking details
        System.out.println("Booking created: ID " + booking.getBookingId() +
                           ", User ID: " + booking.getUserId() +
                           ", Movie: " + booking.getShow().getMovie().getMovieName() +
                           ", Seats: " + booking.getSeats().size() +
                           ", Total Price: " + booking.getTotalPrice() +
                           ", Status: " + booking.getStatus());

        // Test BookingService: Get user’s bookings
        System.out.println("User’s bookings (User ID: " + userId + "):");
        for (Booking userBooking : bookingService.getBookingsByUser(userId)) {
            System.out.println("- Booking ID: " + userBooking.getBookingId() +
                               ", Movie: " + userBooking.getShow().getMovie().getMovieName() +
                               ", Total Price: " + userBooking.getTotalPrice());
        }
    }
}