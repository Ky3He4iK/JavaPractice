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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;

        Address address = (Address) o;

        if (zipCode != address.zipCode) return false;
        if (buildingLetter != address.buildingLetter) return false;
        if (apartmentNumber != address.apartmentNumber) return false;
        if (cityName != null ? !cityName.equals(address.cityName) : address.cityName != null) return false;
        return streetName != null ? streetName.equals(address.streetName) : address.streetName == null;
    }

    @Override
    public int hashCode() {
        int result = cityName != null ? cityName.hashCode() : 0;
        result = 31 * result + zipCode;
        result = 31 * result + (streetName != null ? streetName.hashCode() : 0);
        result = 31 * result + (int) buildingLetter;
        result = 31 * result + apartmentNumber;
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "cityName='" + cityName + '\'' +
                ", zipCode=" + zipCode +
                ", streetName='" + streetName + '\'' +
                ", buildingLetter=" + buildingLetter +
                ", apartmentNumber=" + apartmentNumber +
                '}';
    }
}
