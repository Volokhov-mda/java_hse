package ru.hse.edu.sc.y2020.dLinkedList;

public interface MyList<T> {
    /**
     * Returns value of DNode by index
     * @param index Index
     * @return DNode value
     */
    public T get(int index);

    /**
     * Adds value in the head of the list
     * @param value Value to add
     */
    public void addFirst(T value);

    /**
     * Adds value in the tail of the list
     * @param value Value to add
     */
    public void addLast(T value);

    /**
     * Adds value in the list by index
     * @param value Value to add
     * @param index Index
     */
    public void add(T value, int index);

    /**
     * Removes head value of the list
     */
    public void removeFirst();

    /**
     * Removes tail value of the list
     */
    public void removeLast();

    /**
     * Removes value from the list by index
     * @param index Index
     */
    public void remove(int index);

    /**
     * Check if list contains value entered
     * @param value Value to check
     * @return Boolean value
     */
    public boolean contains(T value);
}
