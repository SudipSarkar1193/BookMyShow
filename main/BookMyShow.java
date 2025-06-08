package main;

import controllers.BookingController;
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
import models.booking.Booking;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookMyShow {

    public static void main(String[] args) {
        System.out.println("Welcome to TicketMaster! Application started successfully.");

        // Initialize services and controller
        TheatreService theatreService = new TheatreService();
        ShowService showService = new ShowService();
        BookingService bookingService = new BookingService();
        BookingController bookingController = new BookingController(theatreService, showService, bookingService);

        // Setup test data
        Movie movie = new Movie(1, "Joker", 132);
        Theatre theatre1 = new Theatre(1, "PVR Cinemas", City.Kalyani);
        Theatre theatre2 = new Theatre(2, "INOX", City.Kolkata);
        theatreService.addTheatre(theatre1);
        theatreService.addTheatre(theatre2);
        Screen screen = new Screen(1, "Screen 1");
        theatre1.addScreen(screen);
        Seat seat1 = new Seat(1, 1, 1, SeatCategory.Platinum);
        Seat seat2 = new Seat(2, 1, 2, SeatCategory.Gold);
        screen.addSeat(seat1);
        screen.addSeat(seat2);
        Show show = new Show(1, movie, screen, LocalDateTime.now(), movie.getMovieDuration());
        bookingController.addShow(theatre1, show);

        // Interactive booking
        Scanner scanner = new Scanner(System.in);
        System.out.println("Available cities: Kalyani, Kolkata");
        System.out.print("Enter city: ");
        String cityInput = scanner.nextLine().trim();
        City city;
        try {
            city = City.valueOf(cityInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid city. Defaulting to Kalyani.");
            city = City.Kalyani;
        }

        List<Theatre> theatres = bookingController.getTheatresByCity(city);
        if (theatres.isEmpty()) {
            System.out.println("No theatres available in " + city + ". Exiting.");
            scanner.close();
            return;
        }
        System.out.println("Theatres in " + city + ":");
        for (int i = 0; i < theatres.size(); i++) {
            System.out.println((i + 1) + ". " + theatres.get(i).getTheatreName());
        }
        System.out.print("Select theatre (1-" + theatres.size() + "): ");
        int theatreIndex = scanner.nextInt() - 1;
        if (theatreIndex < 0 || theatreIndex >= theatres.size()) {
            System.out.println("Invalid selection. Using first theatre.");
            theatreIndex = 0;
        }
        Theatre selectedTheatre = theatres.get(theatreIndex);

        List<Show> shows = bookingController.getShowsByTheatre(selectedTheatre);
        if (shows.isEmpty()) {
            System.out.println("No shows available in " + selectedTheatre.getTheatreName() + ". Exiting.");
            scanner.close();
            return;
        }
        System.out.println("Available shows in " + selectedTheatre.getTheatreName() + ":");
        for (int i = 0; i < shows.size(); i++) {
            System.out.println((i + 1) + ". " + shows.get(i).getMovie().getMovieName() + 
                               " at " + shows.get(i).getStartTime());
        }
        System.out.print("Select show (1-" + shows.size() + "): ");
        int showIndex = scanner.nextInt() - 1;
        if (showIndex < 0 || showIndex >= shows.size()) {
            System.out.println("Invalid selection. Using first show.");
            showIndex = 0;
        }
        Show selectedShow = shows.get(showIndex);

        List<Seat> availableSeats = bookingController.getAvailableSeats(selectedShow);
        if (availableSeats.isEmpty()) {
            System.out.println("No seats available for this show. Exiting.");
            scanner.close();
            return;
        }
        System.out.println("Available seats for " + selectedShow.getMovie().getMovieName() + ":");
        for (int i = 0; i < availableSeats.size(); i++) {
            Seat seat = availableSeats.get(i);
            System.out.println((i + 1) + ". Row " + seat.getRowNumber() + 
                               ", Seat " + seat.getSeatNumber() + 
                               ", Category: " + seat.getCategory() + 
                               ", Price: " + seat.getCategory().getPrice());
        }
        System.out.print("Enter seat numbers to book (e.g., 1 2): ");
        scanner.nextLine(); // Clear buffer
        String[] seatInputs = scanner.nextLine().trim().split("\\s+");
        List<Seat> selectedSeats = new ArrayList<>();
        for (String input : seatInputs) {
            try {
                int seatIndex = Integer.parseInt(input) - 1;
                if (seatIndex >= 0 && seatIndex < availableSeats.size()) {
                    selectedSeats.add(availableSeats.get(seatIndex));
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        if (selectedSeats.isEmpty()) {
            System.out.println("No valid seats selected. Booking cancelled.");
            scanner.close();
            return;
        }

        int userId = 101;
        Booking booking = bookingController.bookTickets(userId, selectedShow, selectedSeats);
        System.out.println("Booking created: ID " + booking.getBookingId() +
                           ", User ID: " + booking.getUserId() +
                           ", Movie: " + booking.getShow().getMovie().getMovieName() +
                           ", Seats: " + booking.getSeats().size() +
                           ", Total Price: " + booking.getTotalPrice() +
                           ", Status: " + booking.getStatus());

        scanner.close();
    }
}