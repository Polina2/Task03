package ru.vsu.cs.aisd.g92.lyigina_p_s;

public class MyLinkedList<T> {
    protected class ListNode {
        private T value;
        private ListNode next;

        public ListNode(T value, ListNode next){
            this.value = value;
            this.next = next;
        }

        public ListNode(T value){
            this(value, null);
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }

    protected ListNode head;
    protected ListNode tail;
    protected int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void addFirst(T value) {
        if (isEmpty()) {
            head = tail = new ListNode(value);
        } else {
            head = new ListNode(value, head);
        }
        size++;
    }

    public void addLast(T value) {
        if (isEmpty())
            head = tail = new ListNode(value);
        else {
            tail.setNext(new ListNode(value));
            tail = tail.getNext();
        }
        size++;
    }

    public void insert(T value, int index) {
        if (index == 0)
            addFirst(value);
        else if (index == size)
            addLast(value);
        else {
            ListNode node = getNode(index - 1);
            node.setNext(new ListNode(value, node.getNext()));
        }
        size++;
    }

    public void removeFirst() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("List is empty");
        if (size == 1) {
            head = tail = null;
        } else {
            head = head.getNext();
        }
        size--;
    }

    public void removeLast() {
        if (size < 2)
            removeFirst();
        else {
            remove(size-1);
        }
        size--;
    }

    public void remove(int index) {
        if (index == size)
            throw new IndexOutOfBoundsException("Index out of bounds");
        if (index == 0)
            removeFirst();
        else {
            ListNode node = getNode(index - 1);
            node.setNext(node.getNext().getNext());
            if (node.getNext() == null)
                tail = node;
        }
        size--;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T get(int index) {
        return getNode(index).getValue();
    }

    protected ListNode getNode(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index out of bounds");
        ListNode current = head;
        int count = 0;
        while (count < index) {
            current = current.getNext();
            count++;
        }
        return current;
    }

    public T getFirst() {
        return head.getValue();
    }

    public T getLast() {
        return tail.getValue();
    }
}
