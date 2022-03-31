package ru.vsu.cs.aisd.g92.lyigina_p_s;

public class MyPriorityQueue<T extends Comparable<T>> extends MyLinkedList<T> implements MyQueue<T> {
    @Override
    public void add(T value) {
        if (isEmpty())
            addLast(value);
        else {
            ListNode cur = head;
            while (cur.getNext() != null && value.compareTo((T) cur.getNext().getValue())>0) {
                cur = cur.getNext();
            }
            ListNode node = new ListNode(value, cur.getNext());
            cur.setNext(node);
            if (node.getNext() == null)
                tail = node;
            size++;
        }
    }

    @Override
    public T remove() throws Exception {
        if (isEmpty())
            throw new Exception("Queue is empty");
        T elem = getFirst();
        removeFirst();
        return elem;
    }

    @Override
    public T element() throws Exception {
        if (isEmpty())
            throw new Exception("Queue is empty");
        return getFirst();
    }
}
