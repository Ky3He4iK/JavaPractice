package dev.ky3he4ik.lab.lab16;

public enum DrinkTypeEnum {
    BEER(new Drink(100, "Beer", "Perfect beer", 0.05, DrinkTypeEnum.BEER)),
    VODKA(new Drink(200, "Vodka", "Just vodka. Please do not play balalayka", 0.4, DrinkTypeEnum.VODKA)),
    BRANDY(new Drink(400, "Brandy", "Classy drink for serious men", 0.4, DrinkTypeEnum.BRANDY)),
    CHAMPANGE(new Drink(450, "Chanpange", "Soft, bubble drink", 0.1, DrinkTypeEnum.CHAMPANGE)),
    WHISKEY(new Drink(500, "Whiskey", "Oh you are a cowboy?", 0.6, DrinkTypeEnum.WHISKEY)),
    TEQUILA(new Drink(400, "Tequila", "Made from pure mexican cactus", 0.5, DrinkTypeEnum.TEQUILA)),
    RUM(new Drink(400, "Rum", "Many not a very good memories are related to rum", 0.4, DrinkTypeEnum.RUM)),
    VERMUTH(new Drink(500, "Vermuth", "The best wine available", 0.15, DrinkTypeEnum.VERMUTH)),
    LIQUOR(new Drink(350, "Liquor", "Same as vodka but better", 0.4, DrinkTypeEnum.LIQUOR)),
    JAGERMEISTER(new Drink(500, "Jagermeister", "Legenday \"Jager\" is here", 0.35, DrinkTypeEnum.JAGERMEISTER)),
    JUICE(new Drink(50, "Juice", "Fresh orange juice", 0, DrinkTypeEnum.JUICE)),
    COFFEE(new Drink(50, "Coffee", "Black as my soul coffee", 0, DrinkTypeEnum.COFFEE)),
    GREEN_TEA(new Drink(50, "Green tea", "Green and eco-friendly tea", 0, DrinkTypeEnum.GREEN_TEA)),
    BLACK_TEA(new Drink(50, "Black tea", "Black and flavored tea", 0, DrinkTypeEnum.BLACK_TEA)),
    MILK(new Drink(50, "Milk", "Milk from a cow", 0, DrinkTypeEnum.MILK)),
    WATER(new Drink(20, "Pure water", "Just water", 0, DrinkTypeEnum.WATER)),
    SODA(new Drink(50, "Soda", "The best soda in this country", 0, DrinkTypeEnum.SODA));

    public final Drink value;

    DrinkTypeEnum(Drink value) {
        this.value = value;
    }
}
