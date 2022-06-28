package Dvdlibrary.ui;

import java.util.Scanner;
public class UIConsoleImpl implements UI {
    
    @Override
    public void say(String message) {
        System.out.println(message);
    }

   @Override
    public String readString() {
        Scanner inputReader;
        String input;

        inputReader = new Scanner(System.in);

        input = inputReader.nextLine();
        return input;
    }
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
