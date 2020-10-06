package dev.ky3he4ik.pr.pr10;

import java.util.Scanner;

public class Client {
    Chair chair;

    public void setChair(Chair chair) {
        this.chair = chair;
    }

    public void sit() {
        chair.sit();
    }

    public static void main(String[] args) {
        System.out.println("You have 3 chair. What chair will you choose?\n1 - Victorian chair\n2 - Functional chair\n3 - Magic chair");
        Scanner scanner = new Scanner(System.in);
        Client client = new Client();
        AbstractChairFactory factory = new ChairFactory();
        switch (scanner.nextInt()) {
            case 1:
                client.setChair(factory.createVictorianChair());
                break;
            case 2:
                client.setChair(factory.createFunctionalChair());
                break;
            case 3:
                client.setChair(factory.createMagicChair());
                break;
        }
        client.sit();
    }
}
