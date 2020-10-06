package dev.ky3he4ik.pr.pr10;

public class VictorianChair implements Chair {
    int age;

    public VictorianChair(int age) {
        this.age = age;
    }

    @Override
    public void sit() {
        System.out.println("You just sat on fancy chair");
    }

    public int getAge() {
        return age;
    }
}
