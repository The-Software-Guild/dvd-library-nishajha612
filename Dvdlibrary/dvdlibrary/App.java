package Dvdlibrary.dvdlibrary;
import Dvdlibrary.controller.Controller;
import Dvdlibrary.ui.UI;
import Dvdlibrary.ui.View;
import Dvdlibrary.ui.UIConsoleImpl;
import Dvdlibrary.dao.Dao;
import Dvdlibrary.dao.DaoFileImpl;

public class App {

    final static String PATH = "src/main/java/Dvdlibrary/roster.txt";

    public static void main(String[] args) {
        View view;
        UI ui;
        Dao dao;

        dao = (Dao) new DaoFileImpl(PATH);
        ui = (UI) new UIConsoleImpl();
        view = (View) new View(ui);
        Controller controller;
        controller = new Controller(view, dao);

        controller.run();
    }
}

