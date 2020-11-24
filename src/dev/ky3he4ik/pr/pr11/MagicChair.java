package dev.ky3he4ik.pr.pr11;

public class MagicChair implements Chair {
    @Override
    public void sit() {
        System.out.println("Oops! You're now a cat!");
    }

    public void doMagic() {
        System.out.println("Magic happened somewhere. But where?");
    }
}
