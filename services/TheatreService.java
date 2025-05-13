package services;

import enums.City;
import models.theatre.Theatre;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TheatreService {
    private List<Theatre> theatres;

    public TheatreService() {
        this.theatres = new ArrayList<>();
    }

    public void addTheatre(Theatre theatre) {
        theatres.add(theatre);
    }

    public List<Theatre> getTheatresByCity(City city) {
        return theatres.stream()
                      .filter(theatre -> theatre.getCity() == city)
                      .collect(Collectors.toList());
    }

    public List<Theatre> getAllTheatres() {
        return new ArrayList<>(theatres);
    }
}