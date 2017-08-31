package com.wrong.ds.stack;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
    private Node<T> head; //top of the stack
    private int size; // size of the stack


    private static class Node<T>{
        private T item;
        private Node<T> next;
    }

    /**
     * initial a empty stack
     */
    public Stack(){
        this.head = null;
        this.size = 0;
    }

    /**
     * Return true of the stack is empty
     * @return true of this stack is empty; false otherwise
     */
    public boolean isEmpty(){
        return this.head == null;
    }


    /**
     * Return the number of items in the stack
     * @return the number of items in the stack
     */
    public int size(){
        return this.size;
    }

    /**
     * adds the item to the stack
     * @param item the item add to stack
     */
    public void push(T item){
        Node<T> newNode = new Node<T>();
        newNode.item = item;
        newNode.next = this.head;
        this.head = newNode;
        this.size++;
    }

    /**
     * return and remove the top element on the stack
     * @return the item most recently added
     * @throws RuntimeException if the stack is empty
     */
    public T pop(){
        if(this.size()==0){
            throw new RuntimeException("The stack is empty");
        }
        Node<T> result = this.head;
        this.head = this.head.next;
        this.size--;
        return result.item;
    }

    /**
     * return the top element ont he stack
     * @return the item most recently added
     * @throws RuntimeException if the stack is empty
     */
    public T peek(){
        if(this.size()==0){
            throw new RuntimeException("The stack is empty");
        }
        return this.head.item;
    }

    /**
     * return string representation to the stack in LIFO order
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T item : this){
            sb.append(item);
            sb.append(" ");
        }
        return sb.toString();
    }

    /**
     * Return an iterator to this stack that iterates through the items in LIFO order.
     * @return
     */
    public Iterator<T> iterator() {
        return new StackIterator<T>(this.head);
    }

    //an iterator
    private class StackIterator<T> implements Iterator<T>{
        private Node<T> current;

        public StackIterator(Node<T> current) {
            this.current = current;
        }

        public boolean hasNext() {
            return this.current != null;
        }

        public T next() {
            if(!hasNext()){
                throw new RuntimeException("Stack Iterator is end");
            }
            T result = this.current.item;
            this.current = this.current.next;
            return result;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}
