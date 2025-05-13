package models.theatre;

import enums.SeatCategory;

public class Seat {
    private int seatId;
    private int rowNumber;
    private int seatNumber;
    private SeatCategory category;

    public Seat(int id, int row, int number, SeatCategory category) {
        this.seatId = id;
        this.rowNumber = row;
        this.seatNumber = number;
        this.category = category;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public SeatCategory getCategory() {
        return category;
    }

    public void setCategory(SeatCategory category) {
        this.category = category;
    }
}