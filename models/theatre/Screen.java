package models.theatre;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    private int screenId;
    private String screenName;
    private List<Seat> seats;

    public Screen(int id, String name) {
        this.screenId = id;
        this.screenName = name;
        this.seats = new ArrayList<>();
    }

    public int getScreenId() {
        return screenId;
    }

    public void setScreenId(int screenId) {
        this.screenId = screenId;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void addSeat(Seat seat) {
        seats.add(seat);
    }
}