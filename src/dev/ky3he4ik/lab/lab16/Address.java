package dev.ky3he4ik.lab.lab16;

public class Address {
    public static final Address EMPTY_ADDRESS = new Address("", 0, "", '\0', 0);
    private final String cityName;
    private final int zipCode;
    private final String streetName;
    private final char buildingLetter;
    private final int apartmentNumber;

    public Address(String cityName, int zipCode, String streetName, char buildingLetter, int apartmentNumber) {
        this.cityName = cityName;
        this.zipCode = zipCode;
        this.streetName = streetName;
        this.buildingLetter = buildingLetter;
        this.apartmentNumber = apartmentNumber;
    }

    public String getCityName() {
        return cityName;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public char getBuildingLetter() {
        return buildingLetter;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }
}
