package main;

import enums.City;
import enums.SeatCategory;
import models.movies.Movie;
import models.theatre.Screen;
import models.theatre.Seat;
import models.theatre.Show;
import models.theatre.Theatre;

import java.time.LocalDateTime;

public class BookMyShow {

    public static void main(String[] args) {
        System.out.println("Welcome to BookMyShow! Application started successfully.");

        // Test Step 3: Create and print Theatre, Screen, Seat, Show
        // Create a Movie
        Movie movie = new Movie(1, "Joker", 132);

        // Create a Theatre
        Theatre theatre = new Theatre(1, "PVR Cinemas", City.Kalyani);

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

        // Print details
        System.out.println("Theatre: " + theatre.getTheatreName() + ", City: " + theatre.getCity());
        System.out.println("Screen: " + screen.getScreenName() + ", Seats: " + screen.getSeats().size());
        System.out.println("Seat 1: Row " + seat1.getRowNumber() + ", Number " + seat1.getSeatNumber() + 
                           ", Category: " + seat1.getCategory() + ", Price: " + seat1.getCategory().getPrice());
        System.out.println("Show: Movie " + show.getMovie().getMovieName() + 
                           ", Start Time: " + show.getStartTime() + 
                           ", Duration: " + show.getDurationInMinutes() + " minutes");
    }
}