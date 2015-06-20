package com.ubs.opsit.interviews.stack;

public class Stack<T> {

    private Object data[];
    private int size;

    public Stack(int initialCapacity) {
        data = new Object [initialCapacity];
    }

    public void push(T val) {
        if (size == data.length) {
            Object newData[] = new Object[data.length * 2];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }


        data[size++] = val;

    }

    @SuppressWarnings("unchecked")
    public T pop() throws StackEmptyException {
        if (isEmpty()) {
            throw new StackEmptyException();
        }
        return (T) data[--size];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

}