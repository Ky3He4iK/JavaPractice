package dev.ky3he4ik.pr.pr8;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Обычная реализация
 * @param <E>
 */
public class WaitList<E> implements IWaitList<E> {
    /**
     * Сама очередь
     */
    protected ConcurrentLinkedQueue<E> content = new ConcurrentLinkedQueue<>();

    /**
     * Конструктор по умолчанию
     */
    WaitList() {
    }

    /**
     * Коснстуктор с заполнением из коллекции @param c
     */
    WaitList(Collection<E> c) {
        content.addAll(c);
    }

    /**
     * Добавление @param element в очередь
     */
    @Override
    public void add(E element) {
        content.add(element);
    }

    /**
     * Удаление первого элемента
     * @return удаленный элемент
     */
    @Override
    public E remove() {
        return content.poll();
    }

    /**
     * @return содержит ли @param element
     */
    @Override
    public boolean contains(E element) {
        return content.contains(element);
    }

    /**
     * @return содержит ли все элементы из @param c
     */
    @Override
    public boolean containsAll(Collection<E> c) {
        return content.containsAll(c);
    }

    /**
     * @return пустая ли очередь
     */
    @Override
    public boolean isEmpty() {
        return content.isEmpty();
    }

    /**
     * @return приведенная в строку очередь
     */
    @Override
    public String toString() {
        return content.toString();
    }
}
