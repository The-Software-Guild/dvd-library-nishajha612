package Dvdlibrary.dao;

import Dvdlibrary.dto.Dvd;
import java.util.HashMap;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collection;

 public class DaoFileImpl implements Dao {

final private HashMap<String, Dvd> library;
        private String path;

        public DaoFileImpl(String path) {
            this.path = path;
            this.library = new HashMap<String, Dvd>();
        }
      @Override
        public void addDvd(Dvd dvd) {
            String title;

            title = dvd.getTitle();

            library.put(title, dvd);
        }
     @Override
        public void removeDvd(String name) {
            library.remove(name);
        }
    @Override
        public Dvd getDvd(String name) {
            return library.get(name);
        }
     @Override
        public void load() {
            Scanner scanner;
            library.clear();

            // Attempt to open the file
            try {
                scanner = new Scanner(
                        new BufferedReader(
                                new FileReader(path)
                        )
                );
            } catch (Exception ex) {
                System.out.println("Failed to open file");
                System.exit(-1);
                return;
            }

            // Iterates line by line in the file to unmarshal and map the DVD
            while (scanner.hasNextLine()) {
                String data;
                Dvd dvd;

                data = scanner.nextLine();
                if (data.equals("")) {
                    break;
                }

                dvd = unmarshal(data);

                library.put(dvd.getTitle(), dvd);
            }
        }

       @Override
        public void save() {
            Collection<Dvd> dvds;
            PrintWriter writer;

            // Attempt to open the file
            try {
                writer = new PrintWriter(
                        new FileWriter(path)
                );
            } catch (Exception ex) {
                System.out.println("Failed to write to file");
                System.exit(-1);
                return;
            }

            // Adds DVDs line by line into the file after marshaling
            dvds = library.values();
            for (Dvd value: dvds) {
                Dvd dvd;
                String data;

                dvd = (Dvd) value;
                data = marshal(dvd);

                writer.println(data);
            }
            writer.close();
        }
       @Override
        public String[] getTitles() {
            Object[] keys;
            String[] titles;

            // Make the keys into an array, then set into a String[] array
            keys = library.keySet().toArray();
            titles = new String[keys.length];
            for (int i = 0; i < keys.length; i++) {
                titles[i] = (String) keys[i];
            }

            return titles;
        }

        public void setPath(String newPath) {
            path = newPath;
        }

      public String getPath() {
            return path;
        }

      private Dvd unmarshal(String data) {
            String[] values;
            Dvd dvd;

            values = data.split("::");
            try {
                dvd = new Dvd(
                        values[0],
                        values[1],
                        Float.parseFloat(values[2]),
                        values[3],
                        values[4],
                        values[5]
                );
            } catch (Exception ex) {
                System.out.println("Failed to unmarchal data: " + data);
                System.exit(-1);
                return null;
            }

            return dvd;
        }

       
        private String marshal(Dvd dvd) {
            String data;

            data = String.format("%s::%s::%f::%s::%s::%s",
                    dvd.getTitle(),
                    dvd.getRelease(),
                    (float) dvd.getRating(),
                    dvd.getDirector(),
                    dvd.getStudio(),
                    dvd.getNote()
            );

            return data;
        }
    }
