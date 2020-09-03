package dev.ky3he4ik.lab.lab3;

public class Bowl extends Dish {
    protected String pattern;

    public Bowl(String pattern, double cost, double durability, boolean isClean) {
        super(cost, durability, isClean);
        this.pattern = pattern;
    }

    public Bowl(String pattern, double cost, double durability) {
        super(cost, durability);
        this.pattern = pattern;
    }

    public Bowl(double cost, double durability, boolean isClean) {
        super(cost, durability, isClean);
        pattern = "None";
    }

    public Bowl(String pattern, double cost) {
        super(cost);
        this.pattern = pattern;
    }

    public Bowl(double durability, double cost) {
        super(cost, durability);
        pattern = "None";
    }

    public Bowl(String pattern) {
        this.pattern = pattern;
    }

    public Bowl(double cost) {
        super(cost);
        pattern = "None";
    }

    public Bowl() {
        pattern = "None";
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}
