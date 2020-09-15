package dev.ky3he4ik.pr.pr8;

import java.util.Collection;

/**
 * Интерфейс для списка ожидания
 * @param <E> - ожидающий элемент
 */
public interface IWaitList<E> {
    /**
     * добавление элемента @param element
     */
    void add(E element);

    /**
     * Извлечение и возврат первого элемента в очереди
     */
    E remove();

    /**
     * Проверка, есть ли @param element в очереди
     */
    boolean contains(E element);

    /**
     * Проверка, есть ли @param c в очереди
     */
    boolean containsAll(Collection<E> c);

    /**
     * Проверка, пустая ли очередь
     */
    boolean isEmpty();
}
