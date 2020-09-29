package dev.ky3he4ik.pr.pr8;

public class Main {
    public static void main(String[] args) {
        WaitList<Integer> waitList = new WaitList<>();
        assert waitList.isEmpty();
        assert !waitList.contains(5);
        waitList.add(5);
        assert waitList.contains(5);
        assert waitList.remove() == 5;

        BoundedWaitList<Integer> waitList2 = new BoundedWaitList<>(3);
        assert waitList2.isEmpty();
        assert waitList2.getCapacity() == 3;
        assert !waitList2.contains(5);
        waitList2.add(5);
        assert waitList2.contains(5);
        assert waitList2.remove() == 5;
        waitList2.add(5);
        waitList2.add(6);
        waitList2.add(7);
        try {
            waitList2.add(8);
            assert false;
        } catch (IllegalStateException e) {
        }

        UnfairWaitList<Integer> waitList3 = new UnfairWaitList<>();
        assert waitList3.isEmpty();
        assert !waitList3.contains(5);
        waitList3.add(5);
        assert waitList3.contains(5);
        assert waitList3.remove() == 5;
        waitList3.add(5);
        waitList3.add(6);
        waitList3.add(7);
        waitList3.remove(5);
        waitList3.moveToBack(6);
        assert waitList3.remove() == 7;
        assert waitList3.remove() == 6;

        System.out.println("WaitLists tested successfully");
    }
}
