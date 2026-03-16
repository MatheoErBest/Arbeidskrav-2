package model;

public class ball extends Equipment {
    private String ballType;     // Lager en verdi for hvilken type ball det er
    private boolean needsAir;    // Setter en true/false for om ballen trenger mer luft

    public ball(int id, String locker, boolean needsReplacement, String ballType, boolean needsAir) {
        super(id, locker, needsReplacement);  // Sender verdier videre til Equipment-klassen
        this.ballType = ballType;
        this.needsAir = needsAir;
    }

    public boolean isNeedsAir() {
        return needsAir;
    }

    @Override
    public String toString() {
        return "Ball (" + ballType + ") - " + super.toString() + ", Needs air: " + needsAir;
    }
}
