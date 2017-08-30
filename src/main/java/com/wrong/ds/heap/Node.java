package com.wrong.ds.heap;

public class Node<E> {
    private E data;
    private int key;

    public Node(E data, int key) {
        this.data = data;
        this.key = key;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", key=" + key +
                '}';
    }
}
