package dev.ky3he4ik.pr.pr11;

public class ChairFactory implements AbstractChairFactory{

    @Override
    public VictorianChair createVictorianChair() {
        return new VictorianChair(42);
    }

    @Override
    public FunctionalChair createFunctionalChair() {
        return new FunctionalChair();
    }

    @Override
    public MagicChair createMagicChair() {
        return new MagicChair();
    }
}
