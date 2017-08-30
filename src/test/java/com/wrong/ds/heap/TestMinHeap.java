package com.wrong.ds.heap;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;
import java.util.UUID;

public class TestMinHeap {
    @Test
    public void testMinHeap(){
        int testRange = 10000000;
        Random random = new Random();
        MinHeap<Integer> heap = new MinHeap<Integer>(testRange);
        int smallest = Integer.MAX_VALUE;
        int r;
        for (int i=0;i<testRange;i++){
            r = random.nextInt(65536)-32768;
            if(r < smallest){
                smallest = r;
            }
            heap.insertKey(new Node(null,r));
        }
        int current;
        int count = 0;
        Node<Integer> result;
        while(heap.getSize()>0){
            result = heap.extractMin();
            current = result.getKey();
            Assert.assertTrue("extractMin has problem",smallest<=current);
            smallest = current;
            count++;
        }
        Assert.assertEquals(count,testRange);
    }

    @Test
    public void testMinHeapBuildFromArray(){
        int testRange = 1000000;
        Random random = new Random();
        Node<String>[] array = new Node[testRange];
        int smallest = Integer.MAX_VALUE;
        int r;
        for (int i=0;i<testRange;i++){
            r = random.nextInt(65536)-32768;
            if(r < smallest){
                smallest = r;
            }
            array[i] = new Node<String>(UUID.randomUUID().toString(),r);
        }
        MinHeap heap = new MinHeap(array,testRange-1);
        int current;
        int count = 0;
        Node<String> result;
        while(heap.getSize()>0){
            result = heap.extractMin();
            current = result.getKey();
            Assert.assertTrue("extractMin has problem",smallest<=current);
            smallest = current;
            count++;
        }
        Assert.assertEquals(count,testRange);

    }
}
