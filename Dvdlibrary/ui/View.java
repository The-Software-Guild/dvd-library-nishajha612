package Dvdlibrary.ui;
import Dvdlibrary.dto.Dvd;
public class View {


    final private UI ui;

    /**
     * Constructs a new View given a UI
     * @param ui the object that handles giving and getting data from the user
     */
    public View(UI ui) {
        this.ui = ui;
    }



    /**
     * Displays a message to the user
     * @param message the message to send to the user
     */
    public void say(String message) {
        ui.say(message);
    }

    /**
     * Requests a string from the user
     * @param message the message to ask the user
     * @return the string inputted by the user
     */
    public String promptString(String message) {
        String response;

        do {
            try {
                ui.say(message);
                response = ui.readString();
                break;
            } catch (Exception e) {}
        } while (true);

        return response;
    }

    /**
     * Requests a double from the user
     * @param message the message to ask the user
     * @return the double inputted by the user
     */
    public double promptDouble(String message) {
        double response;

        do {
            try {
                ui.say(message);
                response = Double.parseDouble(
                        ui.readString()
                );
                break;
            } catch (Exception e) {}
        } while (true);

        return response;
    }

    /**
     * Displays the fields and values of a DVD
     * @param dvd the DVD to show the information of
     */
    public void displayDvdInformation(Dvd dvd) {
        ui.say("\n" + dvd.toString());
    }

    /**
     * Displays the names of an array of DVDs
     * @param dvdNames an array of DVD names
     */
    public void listDvds(String[] dvdNames) {
        ui.say("\nDVDs:");
        for (String title: dvdNames) {
            ui.say(title);
        }
    }
}
