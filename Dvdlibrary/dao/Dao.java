package Dvdlibrary.dao;
import Dvdlibrary.dto.Dvd;

public interface Dao {

    public void addDvd(Dvd dvd);

    /**
     * Removes a DVD from the library
     * @param name the title of the DVD to find and remove
     */
    public void removeDvd(String name);

    /**
     * Gets a DVD given the name
     * @param name the title of the DVD to find
     * @return the DVD
     */
    public Dvd getDvd(String name);

    /**
     * Loads the library of DVDs
     */
    public void load();

    /**
     * Saves the library of DVDs
     */
    public void save();

    /**
     * Gets the titles of all DVDs
     */
    public String[] getTitles();
}
