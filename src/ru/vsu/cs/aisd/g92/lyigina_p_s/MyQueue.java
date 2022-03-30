package ru.vsu.cs.aisd.g92.lyigina_p_s;

public interface MyQueue<T> {
    void add(T value);
    T remove() throws Exception;
    T element() throws Exception;
}
