package dev.ky3he4ik.pr.pr8;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Обычная реализация
 * @param <E>
 */
public class WaitList<E> implements IWaitList<E> {
    protected ConcurrentLinkedQueue<E> content = new ConcurrentLinkedQueue<>();

    /**
     * Конструктор по умолчанию
     */
    WaitList() {
    }

    /**
     * Коснтруктор с заполнением из коллекции @param c
     */
    WaitList(Collection<E> c) {
        content.addAll(c);
    }

    @Override
    public void add(E element) {
        content.add(element);
    }

    @Override
    public E remove() {
        return content.poll();
    }

    @Override
    public boolean contains(E element) {
        return content.contains(element);
    }

    @Override
    public boolean containsAll(Collection<E> c) {
        return content.containsAll(c);
    }

    @Override
    public boolean isEmpty() {
        return content.isEmpty();
    }

    @Override
    public String toString() {
        return content.toString();
    }
}
