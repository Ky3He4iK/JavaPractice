package dev.ky3he4ik.pr.pr8;

/**
 * Список ожидания с ограниченной емкостью
 */
public class BoundedWaitList<E> extends WaitList<E> {
    /**
     * ёмкость очереди
     */
    private int capacity;

    /**
     * Создает очередь с ёмкостью @param capacity
     */
    public BoundedWaitList(int capacity) {
        this.capacity = capacity;
    }

    /**
     * @return ёмкость очередь
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Добавляет @param element в очередь
     */
    @Override
    public void add(E element) {
        if (content.size() < capacity)
            super.add(element);
        else
            throw new IllegalStateException("BoundedWaitList overflow. Maximal capacity: " + capacity);
    }

    /**
     * @return приведенная в строку очередь
     */
    @Override
    public String toString() {
        return "[" + capacity + "] " + content;
    }
}
