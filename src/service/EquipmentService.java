package service;

import model.*;
import java.util.List;

/**
 * Inneholder metodene fra oppgave 2.
 */
public class EquipmentService {
    private List<Equipment> equipmentList;

    public EquipmentService(List<Equipment> equipmentList) {
        this.equipmentList = equipmentList;
    }

    public void printBallsNeedingMoreAir() {
        System.out.println("Disse ballene trenger mer luft");
        for (Equipment e : equipmentList) {
            if (e instanceof ball b && b.isNeedsAir()) {
                System.out.println(b);
            }
        }
    }

    public void printEquipmentNeedingToBeReplaced() {
        System.out.println("Dette utstyret må erstates");
        for (Equipment e : equipmentList) {
            if (e.isNeedsReplacement()) {
                System.out.println(e);
            }
        }
    }

    public void printTableTennisRacketsNeedingNewPad() {
        System.out.println("Disse bordtennis rekkertene trenger ny gummi");
        for (Equipment e : equipmentList) {
            if (e instanceof ttRacket r && r.isNeedsNewPad()) {
                System.out.println(r);
            }
        }
    }
}
