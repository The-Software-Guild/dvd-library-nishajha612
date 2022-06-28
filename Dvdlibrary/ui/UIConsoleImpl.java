package Dvdlibrary.ui;

import java.util.Scanner;
public class UIConsoleImpl implements UI {
    /**
     * Displays a message to the user
     * @param message the message to send to the user
     */
    @Override
    public void say(String message) {
        System.out.println(message);
    }

    /**
     * Reads a String from the user
     * @return the String
     */
    @Override
    public String readString() {
        Scanner inputReader;
        String input;

        inputReader = new Scanner(System.in);

        input = inputReader.nextLine();
        return input;
    }

    /**
     * Reads a double from the user
     * @return the double
     */
    @Override
    public double readDouble() {
        Scanner inputReader;
        String input;
        double value;

        inputReader = new Scanner(System.in);

        input = inputReader.nextLine();
        value = Double.parseDouble(input);

        return value;
    }
}