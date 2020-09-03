package dev.ky3he4ik.lab.lab3;

public class Plate extends Dish {
    protected double capacity;

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


    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }
}
