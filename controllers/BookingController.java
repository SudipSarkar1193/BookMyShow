package controllers;

import enums.City;
import models.theatre.Seat;
import models.theatre.Show;
import models.theatre.Theatre;
import services.BookingService;
import services.ShowService;
import services.TheatreService;
import models.booking.Booking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookingController {
    private final TheatreService theatreService;
    private final ShowService showService;
    private final BookingService bookingService;
    private final List<Show> shows; 

    public BookingController(TheatreService theatreService, ShowService showService, BookingService bookingService) {
        this.theatreService = theatreService;
        this.showService = showService;
        this.bookingService = bookingService;
        this.shows = new ArrayList<>();
    }

    public List<Theatre> getTheatresByCity(City city) {
        return theatreService.getTheatresByCity(city);
    }

    public void addShow(Theatre theatre, Show show) {
        showService.addShow(theatre, show.getScreen(), show);
        shows.add(show); // Store 
    }

    public Booking bookTickets(int userId, Show show, List<Seat> selectedSeats) {
        return bookingService.createBooking(userId, show, selectedSeats);
    }

    public List<Show> getShowsByTheatre(Theatre theatre) {
        return shows.stream()
                    .filter(show -> show.getScreen().getSeats().stream()
                                        .anyMatch(seat -> theatre.getScreens().contains(show.getScreen())))
                    .collect(Collectors.toList());
    }

    public List<Seat> getAvailableSeats(Show show) {
        List<Seat> allSeats = show.getScreen().getSeats();
        List<Seat> bookedSeats = bookingService.getBookingsByUser(0) 
                                               .stream()
                                               .filter(booking -> booking.getShow().getShowId() == show.getShowId())
                                               .flatMap(booking -> booking.getSeats().stream())
                                               .collect(Collectors.toList());
        return allSeats.stream()
                       .filter(seat -> !bookedSeats.contains(seat))
                       .collect(Collectors.toList());
    }
}