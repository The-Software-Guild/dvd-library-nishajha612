package Dvdlibrary.dto;

public class Dvd {


    private String title, release, director, studio, note;
    private double rating;

   public Dvd(String title, String release, double rating, String director, String studio, String note) {
        this.title = title;
        this.release = release;
        this.rating = rating;
        this.director = director;
        this.studio = studio;
        this.note = note;
    }

   public void setTitle(String title) {
        this.title = title;
    }

   public String getTitle() {
        return title;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getRelease() {
        return release;
    }

   public void setRating(double rating) {
        this.rating = rating;
    }

  public double getRating() {
        return rating;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDirector() {
        return director;
    }
  public void setStudio(String studio) {
        this.studio = studio;
    }

   
    public String getStudio() {
        return studio;
    }
public void setNote(String note) {
        this.note = note;
    }

    
    public String getNote() {
        return note;
    }

    
    @Override
    public String toString() {
        return String.format(
                (
                        "Title: %s\n" +
                                "Release Date: %s\n" +
                                "MPAA Rating: %f\n" +
                                "Director: %s\n" +
                                "Studio: %s\n" +
                                "Note: %s"
                ),
                title,
                release,
                rating,
                director,
                studio,
                note
        );
    }
}
