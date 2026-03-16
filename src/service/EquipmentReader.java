package service;

import model.*;     // Henter filene fra model mappen
import java.io.File;    // Brukes for å åpne/lese txt filen
import java.io.FileNotFoundException; // Brukes om txt filen ikke finnes
import java.util.*;     // Henter alle klasser i util f.eks scanner og arraylist

public class EquipmentReader {

    // Leser inn innholdet fra filen, lager objekter og skriver ut resultatet
    public void readAndPrintFromFile(String filename) {
        List<Equipment> equipmentList = new ArrayList<>();  // Lager en liste for alt utstyr

        try (Scanner scanner = new Scanner(new File(filename))) { // Åpner filen for lesing
            while (scanner.hasNextLine()) {  // Leser linje for linje
                String type = scanner.nextLine().trim(); // Leser hvilken type utstyr det er

                if (type.equals("Ball")) {  // Hvis linjen viser at det er en ball
                    int id = Integer.parseInt(scanner.nextLine().trim());   // Leser ID
                    String locker = scanner.nextLine().trim();              // Leser skap
                    boolean replace = Boolean.parseBoolean(scanner.nextLine().trim()); // Leser om ballen må byttes
                    String ballType = scanner.nextLine().trim();            // Leser ball-typen (f.eks. fotball)
                    boolean needsAir = Boolean.parseBoolean(scanner.nextLine().trim()); // Leser om ballen trenger luft

                    // Legger ballen til i listen
                    equipmentList.add(new ball(id, locker, replace, ballType, needsAir));

                } else if (type.equals("TableTennisRacket")) { // Hvis det er en bordtennisracket
                    int id = Integer.parseInt(scanner.nextLine().trim());   // Leser ID
                    String locker = scanner.nextLine().trim();              // Leser skap
                    boolean replace = Boolean.parseBoolean(scanner.nextLine().trim()); // Leser om racketen må byttes
                    boolean needsPad = Boolean.parseBoolean(scanner.nextLine().trim()); // Leser om den trenger ny gummi

                    // Legger racketen til i listen
                    equipmentList.add(new ttRacket(id, locker, replace, needsPad));
                }
            }

            // Når alt er lest inn, skriver vi ut resultater:
            printBallsNeedingMoreAir(equipmentList);
            printEquipmentNeedingReplacement(equipmentList);
            printRacketsNeedingNewPad(equipmentList);

        } catch (FileNotFoundException e) {
            System.out.println("Fant ikke filen: " + filename);  // Feilmelding hvis filen ikke finnes
        }
    }

    // Skriver ut alle baller som trenger mer luft
    private void printBallsNeedingMoreAir(List<Equipment> equipment) {
        System.out.println("\nDisse ballene trenger mer luft:");
        for (Equipment e : equipment) {
            if (e instanceof ball b && b.isNeedsAir()) { // Sjekker om objektet er en ball, og om den trenger luft
                System.out.println(b);
            }
        }
    }

    // Skriver ut alt utstyr som må byttes
    private void printEquipmentNeedingReplacement(List<Equipment> equipment) {
        System.out.println("\nDette utstyret må erstattes:");
        for (Equipment e : equipment) {
            if (e.isNeedsReplacement()) {  // Sjekker om needsReplacement er true
                System.out.println(e);
            }
        }
    }

    // Skriver ut bordtennisracketer som trenger ny gummi
    private void printRacketsNeedingNewPad(List<Equipment> equipment) {
        System.out.println("\nDisse bordtennisrekkertene trenger ny gummi:");
        for (Equipment e : equipment) {
            if (e instanceof ttRacket r && r.isNeedsNewPad()) { // Sjekker om racketen trenger ny pad
                System.out.println(r);
            }
        }
    }
}
