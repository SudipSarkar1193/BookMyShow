package main;

import enums.City;
import models.movies.Movie;

public class BookMyShow {

    public static void main(String[] args) {
        System.out.println("Welcome to TicketMaster! 🎬 Application started successfully.");

         // TEST 
        Movie testMovie = new Movie(1, "Joker", 132);
        City testCity = City.Kalyani;
        System.out.println("Created movie: " + testMovie.getMovieName() + ", Duration: " + testMovie.getMovieDuration() + " minutes, Available in: " + testCity);
    }
}

// C:\Users\DESKTOP\Downloads\apache-maven-3.9.9-bin