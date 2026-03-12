package model;

public class ball extends Equipment {
    private String ballType;
    private boolean needsAir;

    public ball(int id, String locker, boolean needsReplacement, String ballType, boolean needsAir) {
        super(id, locker, needsReplacement);
        this.ballType = ballType;
        this.needsAir = needsAir;
    }

    public String getBallType() {
        return ballType;
    }

    public boolean isNeedsAir() {
        return needsAir;
    }

    @Override
    public String toString() {
        return "Ball (" + ballType + ") - " + super.toString() + ", Needs air: " + needsAir;
    }
}
