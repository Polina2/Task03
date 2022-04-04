package ru.vsu.cs.aisd.g92.lyigina_p_s;

import java.util.Comparator;

public class MyPriorityQueue<T extends Comparable<T>> extends MyLinkedList<T> implements MyQueue<T> {
    private Comparator<T> comparator;

    MyPriorityQueue(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    MyPriorityQueue() {

    }

    @Override
    public void add(T value) {
        if (isEmpty())
            addLast(value);
        else {
            ListNode cur = head;
            if (comparator.compare(value, cur.getValue()) < 0) {
                head = new ListNode(value, cur);
                size++;
                return;
            }
            while (cur.getNext() != null && comparator.compare(value, cur.getNext().getValue()) > 0) {
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
