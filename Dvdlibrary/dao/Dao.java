package Dvdlibrary.dao;
import Dvdlibrary.dto.Dvd;

public interface Dao {
public void addDvd(Dvd dvd);
public void removeDvd(String name);
public Dvd getDvd(String name);
    public void load();
    public void save();

   public String[] getTitles();
}
