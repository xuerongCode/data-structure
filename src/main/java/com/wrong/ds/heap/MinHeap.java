package com.wrong.ds.heap;

/**
 * this class is an implementation of the Binary Heap
 * the min is located in the index of 1
 */
public class MinHeap<E> {
    private Node<E>[] nodes;
    private int capacity;
    private int size;


    public MinHeap(int capacity){
        this.capacity = capacity;
        //start from index 1
        this.nodes = new Node[this.capacity+1];
        this.size = 0;
    }

    /**
     * construct heap from array
     * use shadow copy
     * @param array
     */
    public MinHeap(Node<E>[] array,int endIndex){
        this(array.length);
        //copy input array element
        for(int i=0;i<=endIndex;i++){
            this.nodes[++size] = array[i];
        }

        //build heap
        buildHeap();

    }

    /**
     * insert key into the min heap
     * @param key
     */
    public void insertKey(Node<E> key){
        //if the heap is full, throw an exception
        if(this.size == this.capacity){
            throw new RuntimeException("[MinHeap]: The MinHeap is Full");
        }

        //insert key
        this.nodes[++size] = key;

        //fix the min heap property
        int current = this.size;
        while(current != 1 && this.nodes[parent(current)].getKey() > this.nodes[current].getKey()){
            swap(parent(current),current);
            current = parent(current);
        }

    }

    /**
     * decrease value of key at index location
     * new value should smaller than
     * @param index
     * @param newKey
     */
    public void decreaseKey(int index, int newKey){
        if(index > this.size || index <= 0){
            throw new RuntimeException("[MinHeap]: Index is out of Range");
        }
        if(this.nodes[index].getKey() < newKey){
            throw new RuntimeException("[MinHeap]: value should be greater than existing value");
        }

        this.nodes[index].setKey(newKey);

        //fix the min heap property
        int current = index;
        while(current != 1 && this.nodes[parent(current)].getKey() > this.nodes[current].getKey()){
            swap(parent(current),current);
            current = parent(current);
        }
    }

    /**
     * return and remove the minimum element in the heap
     * @return
     * If it is empty, return the maximum integer value
     */
    public Node<E> extractMin(){
        //if it is empty, return the maximum integer value
        if(this.size <= 0){
            return null;
        }
        //if it has one element
        if(this.size == 1){
            this.size--;
            return this.nodes[1];
        }
        // if it has more than one element
        Node<E> result = this.nodes[1];
        this.nodes[1] = this.nodes[size--];
        minHeapify(1);
        return result;
    }

    /**
     * delete element in the index
     * @param index
     */
    public void deleteKey(int index){
        //decrease element to the minimum integer value
        decreaseKey(index,Integer.MIN_VALUE);
        //use estractMin to delete
        extractMin();
    }

    /**
     * heapify a subtree with root at given index
     * @param index
     */
    public void minHeapify(int index){

        if(index > this.size || index <= 0){
            throw new RuntimeException("[MinHeap]: Index is out of Range");
        }

        int left = leftChild(index);
        int right = rightChild(index);
        int small = index;

        if(left != -1 && this.nodes[left].getKey() < this.nodes[small].getKey()){
            small = left;
        }

        if(right != -1 && this.nodes[right].getKey() < this.nodes[small].getKey()){
            small = right;
        }

        if(small != index){
            swap(index,small);
            minHeapify(small);
        }
    }

    /**
     * check if the heap is full
     * @return
     */
    public boolean isFull(){
        return this.size == this.capacity;
    }

    /**
     * build heap from array
     */
    private void  buildHeap(){
        //do heapify from half size to 1
        for(int i = this.size/2;i>=1;i--){
            minHeapify(i);
        }
    }

    /**
     * return the parent index
     * return -1 if this is root
     * @param index
     * @return
     */
    private int parent(int index){
        if(index == 1){
            return -1;
        }
        return index/2;
    }

    /**
     * return the index of left child
     * return -1 if no left child
     * @param index
     * @return
     */
    private int leftChild(int index){
        int result = index * 2;
        return result <= size ? result : -1;
    }

    /**
     * return the index of right child
     * return -1 of no right child
     * @param index
     * @return
     */
    private int rightChild(int index){
        int result = index * 2 + 1;
        return result <= size ? result : -1;
    }

    /**
     * swap two element in the Nodes array
     * @param index1
     * @param index2
     * @return
     */
    private void swap(int index1,int index2){
        Node<E> temp = this.nodes[index1];
        this.nodes[index1] = this.nodes[index2];
        this.nodes[index2] = temp;
    }

    /**
     * return size of the heap
     * @return
     */
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("^ MinHeap\n");
        sb.append("| Capacity: " + this.capacity + "\n");
        sb.append("| size: " + this.size + "\n");
        sb.append("$ value: [");
        for (int i=1;i<this.size;i++){
            sb.append(this.nodes[i]+",");
        }
        sb.append(this.nodes[this.size]+"]\n");
        return sb.toString();
    }
}
