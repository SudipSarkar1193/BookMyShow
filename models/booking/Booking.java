package models.booking;

import enums.BookingStatus;
import models.theatre.Seat;
import models.theatre.Show;

import java.util.List;

public class Booking {
    private int bookingId;
    private int userId;
    private Show show;
    private List<Seat> seats;
    private double totalPrice;
    private BookingStatus status;

    public Booking(int id, int userId, Show show, List<Seat> seats, double totalPrice) {
        this.bookingId = id;
        this.userId = userId;
        this.show = show;
        this.seats = seats;
        this.totalPrice = totalPrice;
        this.status = BookingStatus.Pending;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }
}