package dev.ky3he4ik.lab.lab3;

public class DishesTest {
    public static void main(String[] args) {
        Plate plate = new Plate(123, 321, 12, false);
        assert plate.getCapacity() == 123;
        assert plate.getCost() == 321;
        assert plate.getDurability() == 12;
        assert !plate.isClean();
        plate = new Plate();
        assert plate.getCapacity() == 0;
        assert plate.getCost() == 0;
        assert plate.getDurability() == 0;
        assert plate.isClean();
        plate.setCapacity(1);
        plate.setCost(2);
        plate.setDurability(3);
        plate.setClean(false);
        assert plate.getCapacity() == 1;
        assert plate.getCost() == 2;
        assert plate.getDurability() == 3;
        assert !plate.isClean();
        plate.setClean(true);
        plate.fill();
        assert plate.getCurrCapacity() == plate.getCapacity();
        assert !plate.isClean();

        Bowl bowl = new Bowl("Simple", 321, 12, false);
        assert bowl.getPattern().equals("Simple");
        assert bowl.getCost() == 321;
        assert bowl.getDurability() == 12;
        assert !bowl.isClean();
        bowl = new Bowl();
        assert bowl.getPattern().equals("None");
        assert bowl.getCost() == 0;
        assert bowl.getDurability() == 0;
        assert bowl.isClean();
        bowl.setPattern("Golden");
        bowl.setCost(654);
        bowl.setDurability(8);
        bowl.setClean(false);
        assert bowl.getPattern().equals("Golden");
        assert bowl.getCost() == 654;
        assert bowl.getDurability() == 8;
        assert !bowl.isClean();
        bowl.setClean(true);
        bowl.fill();
        assert !bowl.isClean();
        System.out.println("Dishes tested successfully");
    }
}
