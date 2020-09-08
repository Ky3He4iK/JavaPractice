package dev.ky3he4ik.lab.lab3;

public class Plate extends Dish {
    protected double capacity;
    protected double currCapacity = 0;

    public Plate(double capacity, double cost, double durability, boolean isClean) {
        super(cost, durability, isClean);
        this.capacity = capacity;
    }

    public Plate(double cost, double durability, boolean isClean) {
        super(cost, durability, isClean);
    }

    public Plate(double capacity, double cost, double durability) {
        super(cost, durability);
        this.capacity = capacity;
    }

    public Plate(double capacity, double cost) {
        super(cost);
        this.capacity = capacity;
    }

    public Plate() {
        super();
        capacity = 0;
    }

    @Override
    void fill() {
        isClean = false;
        currCapacity = capacity;
    }

    @Override
    public void setClean(boolean clean) {
        if (clean)
            currCapacity = 0;
        super.setClean(clean);
    }

    public double getCurrCapacity() {
        return currCapacity;
    }

    @Override
    public String toString() {
        return "Plate " + durability + "/" + durability + "; cost: " + cost + "$; capacity: " + capacity + "ml " + (isClean ? "clean" : "dirty");
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }
}
