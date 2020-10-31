package ru.hse.edu.sc.y2020.dLinkedList;

public class DNode<T> {
    private T value;
    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }

    private DNode<T> prev;
    public DNode<T> getPrev() {
        return prev;
    }
    public void setPrev(DNode<T> prev) {
        this.prev = prev;
    }

    private DNode<T> next;
    public DNode<T> getNext() {
        return next;
    }
    public void setNext(DNode<T> next) {
        this.next = next;
    }

    public DNode(T value) {
        setValue(value);
    }
}
