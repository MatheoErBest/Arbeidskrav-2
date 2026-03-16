package model;

public class ttRacket extends Equipment {
    private boolean needsNewPad;   // Setter en true/false for om racketen trenger ny gummi

    public ttRacket(int id, String locker, boolean needsReplacement, boolean needsNewPad) {
        super(id, locker, needsReplacement);  // Arver felles egenskaper fra Equipment
        this.needsNewPad = needsNewPad;
    }

    public boolean isNeedsNewPad() {
        return needsNewPad;
    }

    @Override
    public String toString() {
        return "TableTennisRacket - " + super.toString() + ", Needs new pad: " + needsNewPad;
    }
}
