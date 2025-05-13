package services;

import models.theatre.Screen;
import models.theatre.Show;
import models.theatre.Theatre;

public class ShowService {
    public void addShow(Theatre theatre, Screen screen, Show show) {
        // Ensure that the screen belongs to the theatre
        if (!theatre.getScreens().contains(screen)) {
            throw new IllegalArgumentException("Screen does not belong to the specified theatre");
        }
        // Ensure that the show’s screen matches the provided screen
        if (show.getScreen() != screen) {
            throw new IllegalArgumentException("Show’s screen does not match the provided screen");
        }
        // In a real system, add show to a list or DB
        // For now, associating show with screen 
        System.out.println("Show added: " + show.getMovie().getMovieName() + 
                           " on Screen " + screen.getScreenName());
    }
}