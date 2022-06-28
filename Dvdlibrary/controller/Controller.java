package Dvdlibrary.controller;
import    Dvdlibrary.dto.Dvd;
import Dvdlibrary.ui.View;
import  Dvdlibrary.dao.Dao;

public class Controller {




        final private View view;
        final  private Dao dao;
        /**
         * Constructs a new Controller given a view and dao to use
         * @param view  the object that handles interactions with the user
         * @param dao   the object that handles loading, saving, and accessing DVDs from the library
         */
        public Controller(View view, Dao dao) {
            this.view = view;
            this.dao = dao;
        }

        /**
         * Iteratively requests a command from the user and handles the command onto the Dvd library
         */
        public void run() {
            String selection;

            load();
            view.say("Welcome to your library.");

            mainMenu: do {
                // Requests the user's selection
                selection = view.promptString(
                        "\nWhat would you like to do?\n" +
                                "\tADD - adds a DVD\n" +
                                "\tREMOVE - removes a DVD\n" +
                                "\tSELECT - selects a DVD for editing or viewing information\n" +
                                "\tLIST - lists all DVDs in the library\n" +
                                "\tEXIT - saves any updates and exits the app"
                );

                // Handles the user's selection
                switch (selection.toLowerCase()) {
                    case ("add"):
                        addDvd();
                        break;
                    case ("remove"):
                        removeDvd();
                        break;
                    case ("select"):
                        selectDvd();
                        break;
                    case ("list"):
                        listDvds();
                        break;
                    case ("exit"):
                        break mainMenu;
                    default:
                        continue;
                }
            } while (true);

            exit();
        }

        /**
         * Gets a DVD from the user and adds it to the library
         */
        private void addDvd() {
            String title, release, director, studio, note;
            double rating;
            Dvd dvd;

            title = view.promptString("\nWhat is the title of the movie?");
            release = view.promptString("When was the movie released?");
            rating = view.promptDouble("What is the MPAA rating of the movie?");
            director = view.promptString("Who directed the movie?");
            studio = view.promptString("What studio made the movie?");
            note = view.promptString("Please leave a note on the DVD.");
            dvd = new Dvd(title, release, rating, director, studio, note);
            dao.addDvd(dvd);
            view.say("Added.");
        }

        /**
         * Gets a DVD name from the user and removes it from the library
         */
        private void removeDvd() {
            String title;

            title = view.promptString("\nWhat is the title of the movie?");
            dao.removeDvd(title);
            view.say("Removed.");
        }

        /**
         * Gets what field to edit in the select DVD and what value to set, then sets it
         * Updates the DVDs key in the library if the title has changed
         */
        private void editDvd(Dvd dvd) {
            String selection, stringValue, oldTitle;
            double doubleValue;

            // Iteratively get a DVD field to edit and edit
            editMenu: do {
                selection = view.promptString(
                        "\nWhat would like to edit?\n" +
                                "TITLE, RELEASE, RATING, DIRECTOR, STUDIO, NOTE\n" +
                                "or EXIT"
                );

                // Handles the user's selection of field
                switch (selection.toLowerCase()) {
                    case ("title"):
                        oldTitle = dvd.getTitle();
                        stringValue = view.promptString("\nWhat is the new title?");
                        dvd.setTitle(stringValue);

                        dao.removeDvd(oldTitle);
                        dao.addDvd(dvd);
                        break;
                    case ("release"):
                        stringValue = view.promptString("\nWhat is the new release date?");
                        dvd.setRelease(stringValue);
                        break;
                    case ("rating"):
                        doubleValue = view.promptDouble("\nWhat is the new rating?");
                        dvd.setRating(doubleValue);
                        break;
                    case ("director"):
                        stringValue = view.promptString("\nWhat is the new director?");
                        dvd.setNote(stringValue);
                        break;
                    case ("studio"):
                        stringValue = view.promptString("\nWhat is the new studio?");
                        dvd.setStudio(stringValue);
                        break;
                    case ("note"):
                        stringValue = view.promptString("\nWhat is the new note?");
                        dvd.setNote(stringValue);
                        break;
                    case ("exit"):
                        break editMenu;
                    default:
                        continue;
                }
            } while (true);
        }

        /**
         * Displays the titles of all DVDs in the library
         */
        private void listDvds() {
            String titles[];

            titles = dao.getTitles();
            view.listDvds(titles);
        }

        /**
         * Displays the fields and values in the select DVD
         */
        private void displayDvd(Dvd dvd) {
            view.displayDvdInformation(dvd);
        }

        /**
         * Selects a DVD
         */
        private void selectDvd() {
            String title, selection;
            Dvd dvd;

            // Requests the DVD title
            title = view.promptString("\nWhat is the title of the movie?");
            dvd = dao.getDvd(title);

            // Make sure the DVD exists
            if (dvd == null) {
                view.say("\"" + title + "\" does not exist.");
                return;
            }

            // Iteratively requests and handles this DVD until exit
            dvdMenu: do {
                // Requests a selection to the DVD
                selection = view.promptString(
                        "\nWhat would you like to do with " + dvd.getTitle() + "?\n" +
                                "\tEDIT - edit information on the DVD\n" +
                                "\tDISPLAY - display the current information on the DVD\n" +
                                "\tEXIT - return to the main menu"
                );

                // Handles the selection
                switch (selection.toLowerCase()) {
                    case ("edit"):
                        editDvd(dvd);
                        break;
                    case ("display"):
                        displayDvd(dvd);
                        break;
                    case ("exit"):
                        break dvdMenu;
                    default:
                        continue;
                }
            } while (true);
        }

        /**
         * Loads the library information
         */
        private void load() {
            dao.load();
        }

        /**
         * Saves and displays a goodbye message
         */
        private void exit() {
            dao.save();
            view.say("Goodbye.");
        }
    }
