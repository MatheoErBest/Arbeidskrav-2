package model;

public class Equipment {
    private int id;         // Lager en ID for equipment
    private String locker;  // Lager en verdi for hvilket skap utstyret ligger i
    private boolean needsReplacement;   // Setter en true/false om utstyret må byttes

    public Equipment(int id, String locker, boolean needsReplacement) {
        this.id = id;
        this.locker = locker;
        this.needsReplacement = needsReplacement;
    }

    public int getId() {
        return id;
    }

    public String getLocker() {
        return locker;
    }

    public boolean isNeedsReplacement() {
        return needsReplacement;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Locker: " + locker + ", Needs replacement: " + needsReplacement;
    }
}
