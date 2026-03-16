import service.EquipmentReader;

public class Main {
    public static void main(String[] args) {
        EquipmentReader reader = new EquipmentReader();  // Lager et objekt som skal lese utstyr
        reader.readAndPrintFromFile("equipment.txt");     // Leser og skriver ut data fra filen
    }
}
