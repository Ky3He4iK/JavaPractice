package dev.ky3he4ik.lab.lab16;

public class Drink extends MenuItem implements Alcoholable {
    private final double alcoholVol;
    private final DrinkTypeEnum type;

    public Drink(int cost, String name, String description, double alcoholVol, DrinkTypeEnum type) {
        super(cost, name, description);
        this.alcoholVol = alcoholVol;
        this.type = type;
    }

    public Drink(String name, String description, double alcoholVol, DrinkTypeEnum type) {
        super(name, description);
        this.alcoholVol = alcoholVol;
        this.type = type;
    }

    @Override
    public boolean isAlcoholicDrink() {
        return alcoholVol > 0;
    }

    @Override
    public double getAlcoholVol() {
        return alcoholVol;
    }

    public DrinkTypeEnum getType() {
        return type;
    }
}
