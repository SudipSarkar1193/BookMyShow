package models.movies;

public class Movie {

    private int filmId;
    private String filmTitle;
    private int filmLengthInMinutes;

    public Movie(int id, String title, int duration) {
        this.filmId = id;
        this.filmTitle = title;
        this.filmLengthInMinutes = duration;
    }

    public int getMovieId() {
        return filmId;
    }

    public void setMovieId(int filmId) {
        this.filmId = filmId;
    }

    public String getMovieName() {
        return filmTitle;
    }

    public void setMovieName(String filmTitle) {
        this.filmTitle = filmTitle;
    }

    public int getMovieDuration() {
        return filmLengthInMinutes;
    }

    public void setMovieDuration(int filmLength) {
        this.filmLengthInMinutes = filmLength;
    }
}