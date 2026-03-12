import model.Equipment;
import service.EquipmentReader;
import service.EquipmentService;
import java.util.List;

/**
 * Starter programmet og tester klasser fra service- og model-pakken.
 */
public class Main {
    public static void main(String[] args) {
        EquipmentReader reader = new EquipmentReader();
        List<Equipment> equipmentList = reader.readFromFile("equipment.txt");

        EquipmentService service = new EquipmentService(equipmentList);

        service.printBallsNeedingMoreAir();
        service.printEquipmentNeedingToBeReplaced();
        service.printTableTennisRacketsNeedingNewPad();
    }
}
