package dev.ky3he4ik.lab.lab16;

public class QueueNode {
    QueueNode prev;
    QueueNode next;
    Order value;

    public QueueNode(QueueNode prev, QueueNode next, Order value) {
        this.prev = prev;
        this.next = next;
        this.value = value;
    }

    public QueueNode() {
        value = null;
        prev = next = null;
    }
}
