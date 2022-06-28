package Dvdlibrary.ui;
import Dvdlibrary.dto.Dvd;
public class View {


    final private UI ui;
    public View(UI ui) {
        this.ui = ui;
    }

public void say(String message) {
        ui.say(message);
    }

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

   
    public void displayDvdInformation(Dvd dvd) {
        ui.say("\n" + dvd.toString());
    }

     public void listDvds(String[] dvdNames) {
        ui.say("\nDVDs:");
        for (String title: dvdNames) {
            ui.say(title);
        }
    }
}
