package Dvdlibrary.ui;

public interface UI {

    public void say(String message);

    /**
     * Reads a String from the user
     * @return the String
     */
    public String readString();

    /**
     * Reads a double from the user
     * @return the double
     */
    public double readDouble();
}
