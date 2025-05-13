package models.theatre;

import enums.City;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    private int theatreId;
    private String theatreName;
    private City city;
    private List<Screen> screens;

    public Theatre(int id, String name, City city) {
        this.theatreId = id;
        this.theatreName = name;
        this.city = city;
        this.screens = new ArrayList<>();
    }

    public int getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void addScreen(Screen screen) {
        screens.add(screen);
    }
}