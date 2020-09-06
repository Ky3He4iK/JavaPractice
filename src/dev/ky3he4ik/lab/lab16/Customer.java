package dev.ky3he4ik.lab.lab16;

public class Customer {
    private static final Customer MATURE_UNKNOWN_CUSTOMER = new Customer("Unknown", "customer", 99, Address.EMPTY_ADDRESS);
    private static final Customer NOT_MATURE_UNKNOWN_CUSTOMER = new Customer("Unknown", "customer", 99, Address.EMPTY_ADDRESS);
    private String firstName;
    private String secondName;
    private int age;
    private Address address;

    public Customer(String firstName, String secondName, int age, Address address) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }
}
