package dev.ky3he4ik.pr.pr8;

/**
 * Список ожидания, в котором можно любой элемент удалить либо переместить в конец
 */
public class UnfairWaitList<E> extends WaitList<E> {
    /**
     * Удаление @param element
     */
    public void remove(E element) {
        content.remove(element);
    }

    /**
     * Перемещение в конец @param element
     */
    public void moveToBack(E element) {
        if (content.remove(element))
            content.add(element);
    }
}
