package Dvdlibrary.dto;

public class Dvd {


    private String title, release, director, studio, note;
    private double rating;

    /**
     * Constructs a new Dvd given each field
     * @param title the title
     * @param release the release date
     * @param rating the MPAA rating
     * @param director the director name
     * @param studio the studio name
     * @param note the user's note on the Dvd
     */
    public Dvd(String title, String release, double rating, String director, String studio, String note) {
        this.title = title;
        this.release = release;
        this.rating = rating;
        this.director = director;
        this.studio = studio;
        this.note = note;
    }

    /**
     * Sets the title of this DVD
     * @param title the new title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the title of this DVD
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the release date of this DVD
     * @param release the new release date
     */
    public void setRelease(String release) {
        this.release = release;
    }

    /**
     * Gets the release date of this DVD
     * @return the release date
     */
    public String getRelease() {
        return release;
    }

    /**
     * Sets the MPAA rating of this DVD
     * @param rating the new rating
     */
    public void setRating(double rating) {
        this.rating = rating;
    }

    /**
     * Gets the rating of this DVD
     * @return the rating
     */
    public double getRating() {
        return rating;
    }

    /**
     * Sets the name of the director of this DVD
     * @param director the new director
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Gets the name of the director of this DVD
     * @return the director
     */
    public String getDirector() {
        return director;
    }

    /**
     * Sets the studio name of this DVD
     * @param studio the new studio name
     */
    public void setStudio(String studio) {
        this.studio = studio;
    }

    /**
     * Gets the title of this DVD
     * @return the title
     */
    public String getStudio() {
        return studio;
    }

    /**
     * Sets the note of this DVD
     * @param note the new note
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * Gets the title of this DVD
     * @return the title
     */
    public String getNote() {
        return note;
    }

    /**
     * Gets the information on this DVD
     * @return the information
     */
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
