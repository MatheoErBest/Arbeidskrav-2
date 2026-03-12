package service;

import model.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Leser sportsutstyr fra equipment.txt og lager objekter.
 */
public class EquipmentReader {

    public List<Equipment> readFromFile(String filename) {
        List<Equipment> list = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String type = scanner.nextLine().trim();

                if (type.equals("Ball")) {
                    int id = Integer.parseInt(scanner.nextLine().trim());
                    String locker = scanner.nextLine().trim();
                    boolean replace = Boolean.parseBoolean(scanner.nextLine().trim());
                    String ballType = scanner.nextLine().trim();
                    boolean needsAir = Boolean.parseBoolean(scanner.nextLine().trim());
                    list.add(new ball(id, locker, replace, ballType, needsAir));

                } else if (type.equals("TableTennisRacket")) {
                    int id = Integer.parseInt(scanner.nextLine().trim());
                    String locker = scanner.nextLine().trim();
                    boolean replace = Boolean.parseBoolean(scanner.nextLine().trim());
                    boolean needsPad = Boolean.parseBoolean(scanner.nextLine().trim());
                    list.add(new ttRacket(id, locker, replace, needsPad));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fant ikke filen: " + filename);
        }

        return list;
    }
}
