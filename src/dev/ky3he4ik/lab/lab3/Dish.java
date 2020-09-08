package dev.ky3he4ik.lab.lab3;

abstract public class Dish {
    protected double cost;
    protected double durability;
    protected boolean isClean;

    public Dish(double cost, double durability, boolean isClean) {
        this.cost = cost;
        this.durability = durability;
        this.isClean = isClean;
    }

    public Dish(double cost, double durability) {
        this.cost = cost;
        this.durability = durability;
        isClean = true;
    }

    public Dish(double cost) {
        this.cost = cost;
        durability = 0;
        isClean = true;
    }

    public Dish() {
        cost = 0;
        durability = 0;
        isClean = true;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getDurability() {
        return durability;
    }

    public void setDurability(double durability) {
        this.durability = durability;
    }

    public boolean isClean() {
        return isClean;
    }

    public void setClean(boolean clean) {
        isClean = clean;
    }

    abstract void fill();

    @Override
    public abstract String toString();
}
