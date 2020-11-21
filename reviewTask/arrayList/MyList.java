package ru.hse.edu.sc.y2020.arrayList;

public interface MyList<T> {
    /**
     * Returns value of DNode by index
     * @param index Index
     * @return DNode value
     */
    public T get(int index);

    /**
     * Adds element at the end of the collection
     * @param value Value to add
     */
    public void put(T value);

    /**
     * Returns the collection size
     * @return Collection size
     */
    public int size();

    /**
     * Check if collection contains value entered
     * @param value Value to check
     * @return true if collection contains value, otherwise false
     */
    public boolean contains(T value);

    /**
     * Removes all the elements from the collection
     */
    public void clear();
}
