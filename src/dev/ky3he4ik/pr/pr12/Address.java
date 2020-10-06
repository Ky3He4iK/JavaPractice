package dev.ky3he4ik.pr.pr12;

import java.util.StringTokenizer;

public class Address {
    String country;
    String region;
    String city;
    String street;
    String house;
    String housing;
    String flat;

    public Address(String country, String region, String city, String street, String house, String housing, String flat) {
        this.country = country;
        this.region = region;
        this.city = city;
        this.street = street;
        this.house = house;
        this.housing = housing;
        this.flat = flat;
    }

    @Override
    public String toString() {
        return "Country: " + country +
                " Region: " + region +
                " City: " + city +
                " Street: " + street +
                " House: " + house +
                " Housing: " + housing +
                " Flat: " + flat;
    }

    public static Address fromStringA(String address) {
        String[] tokens = address.split(", ");
        if (tokens.length == 7)
            return new Address(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], tokens[5], tokens[6]);
        return null;
    }

    public static Address fromStringB(String address) {
        StringTokenizer tokenizer = new StringTokenizer(address, ",.;-");

        if (tokenizer.countTokens() == 7)
            return new Address(tokenizer.nextToken().trim(), tokenizer.nextToken().trim(), tokenizer.nextToken().trim(),
                    tokenizer.nextToken().trim(), tokenizer.nextToken().trim(), tokenizer.nextToken().trim(), tokenizer.nextToken().trim());
        return null;
    }


}
