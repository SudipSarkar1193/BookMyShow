package main;

import enums.City;
import enums.SeatCategory;
import models.movies.Movie;
import models.theatre.Screen;
import models.theatre.Seat;
import models.theatre.Show;
import models.theatre.Theatre;
import services.ShowService;
import services.TheatreService;

import java.time.LocalDateTime;

public class BookMyShow {

    public static void main(String[] args) {
        System.out.println("Welcome to BookMyShow! Application started successfully.");

        // TESTING : TheatreService and ShowService
        // Creating services
        TheatreService theatreService = new TheatreService();
        ShowService showService = new ShowService();

        // Creating a Movie
        Movie movie = new Movie(1, "Joker", 132);

        // Creating Theatres
        Theatre theatre1 = new Theatre(1, "PVR Cinemas", City.Kalyani);
        Theatre theatre2 = new Theatre(2, "INOX", City.Kolkata);
        theatreService.addTheatre(theatre1);
        theatreService.addTheatre(theatre2);

        // Creating a Screen for theatre1
        Screen screen = new Screen(1, "Screen 1");
        theatre1.addScreen(screen);

        // Creating Seats for the screen
        Seat seat1 = new Seat(1, 1, 1, SeatCategory.Platinum);
        Seat seat2 = new Seat(2, 1, 2, SeatCategory.Gold);
        screen.addSeat(seat1);
        screen.addSeat(seat2);

        // Creating a Show
        Show show = new Show(1, movie, screen, LocalDateTime.now(), movie.getMovieDuration());
        showService.addShow(theatre1, screen, show);

        // Testing TheatreService: Get theatres in Kalyani
        System.out.println("Theatres in Kalyani:");
        for (Theatre theatre : theatreService.getTheatresByCity(City.Kalyani)) {
            System.out.println("- " + theatre.getTheatreName() + ", Screens: " + 
                               theatre.getScreens().size());
        }

        // Testing TheatreService: Get all theatres
        System.out.println("All Theatres:");
        for (Theatre theatre : theatreService.getAllTheatres()) {
            System.out.println("- " + theatre.getTheatreName() + ", City: " + 
                               theatre.getCity());
        }
    }
}