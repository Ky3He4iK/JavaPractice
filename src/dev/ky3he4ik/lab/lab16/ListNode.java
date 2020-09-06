package dev.ky3he4ik.lab.lab16;

public class ListNode {
    ListNode prev;
    MenuItem value;

    public ListNode(ListNode prev, MenuItem value) {
        this.prev = prev;
        this.value = value;
    }

    public ListNode() {
        prev = null;
        value = null;
    }
}
