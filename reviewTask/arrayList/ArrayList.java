package ru.hse.edu.sc.y2020.arrayList;

import java.util.Arrays;

public class ArrayList<T> implements MyList<T> {
    private final int DEFAULT_SIZE = 10;
    private int currentSize = 0;
    private Object[] innerArray;

    @Override
    public T get(int index) {
        // Обрабатывать случай выхода за границы массива не надо, так как массив сам при необходимости выкинет его.
        return (T)innerArray[index];
    }

    @Override
    public void put(T value) {
        if (currentSize == innerArray.length - 1) {
            // Невыгодно ресайзить массив на один элемент (innerArray.length + 1), так как это дорогостоящая операция, так что ресайзим на DEFAULT_SIZE, чтобы избежать
            // ресайз при каждом put. Не стал увеличивать в n размер массива при каждом переполнении, так как тогда размер в теории может оказаться слишком большим.
            resize(innerArray.length + DEFAULT_SIZE);
        }

        innerArray[currentSize++] = value;
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public boolean contains(T value) {
        return Arrays.stream(innerArray).anyMatch(value::equals);
    }

    @Override
    public void clear() {
        innerArray = new Object[DEFAULT_SIZE];
        currentSize = 0;
    }

    /**
     * Changes the size of inner array
     */
    private void resize(int newSize) {
        Object[] newArray = new Object[newSize];
        System.arraycopy(innerArray, 0, newArray, 0, size());
        innerArray = newArray;
    }

    /**
     * Default constructor of ArrayList with capacity 10.
     */
    public ArrayList() {
        innerArray = new Object[DEFAULT_SIZE];
    }

    /**
     * Constructor of ArrayList with capacity mentioned.
     */
    public ArrayList(int initSize) {
        innerArray = new Object[initSize];
    }
}
