package dev.ky3he4ik.pr.pr10;

public class FunctionalChair implements Chair {
    public int sum(int a, int b) {
        return a + b;
    }

    @Override
    public void sit() {
        System.out.println("You opened with your char a beer and sitting here");
    }
}
