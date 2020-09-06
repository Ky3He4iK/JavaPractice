package dev.ky3he4ik.lab.lab16;


import java.util.Objects;

public class MenuItem {
    private int cost;
    private String name;
    private String description;

    public MenuItem(int cost, String name, String description) {
        this.cost = cost;
        this.name = name;
        this.description = description;
    }

    public MenuItem(String name, String description) {
        this.name = name;
        this.description = description;
        cost = 0;
    }

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MenuItem)) return false;
        MenuItem menuItem = (MenuItem) o;
        return cost == menuItem.cost &&
                Objects.equals(name, menuItem.name) &&
                Objects.equals(description, menuItem.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cost, name, description);
    }
}
