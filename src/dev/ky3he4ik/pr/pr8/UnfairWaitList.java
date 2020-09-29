package dev.ky3he4ik.pr.pr8;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Список ожидания, в котором можно любой элемент удалить либо переместить в конец
 */
public class UnfairWaitList<E> extends WaitList<E> {
    protected ConcurrentLinkedQueue<E> exp = new ConcurrentLinkedQueue<>();

    /**
     * Удаление @param element
     */
    public void remove(E element) {
        if (!content.peek().equals(element)) {
            content.remove(element);
            exp.add(element);
        }
    }

    @Override
    public void add(E element) {
        if (!exp.contains(element))
            super.add(element);
    }

    /**
     * Перемещение в конец @param element
     */
    public void moveToBack(E element) {
        if (content.remove(element))
            content.add(element);
    }
}
