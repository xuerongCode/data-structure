package com.wrong.ds.heap;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class TestMinHeap {
    @Test
    public void testMinHeap(){
        Random random = new Random();
        MinHeap heap = new MinHeap(10000000);
        int smallest = Integer.MAX_VALUE;
        int r;
        for (int i=0;i<10000000;i++){
            r = random.nextInt(65536)-32768;
            if(r < smallest){
                smallest = r;
            }
            heap.insertKey(r);
        }
        int current;
        int count = 0;
        while(heap.getSize()>0){
            current = heap.extractMin();
            Assert.assertTrue("extractMin has problem",smallest<=current);
            smallest = current;
            count++;
        }
        Assert.assertEquals(count,10000000);
    }

    @Test
    public void testMinHeapBuildFromArray(){
        Random random = new Random();
        int[] array = new int[10000000];
        int smallest = Integer.MAX_VALUE;
        int r;
        for (int i=0;i<100;i++){
            r = random.nextInt(65536)-32768;
            if(r < smallest){
                smallest = r;
            }
            array[i] = r;
        }
        MinHeap heap = new MinHeap(array,10000000-1);
        int current;
        int count = 0;
        while(heap.getSize()>0){
            current = heap.extractMin();
            Assert.assertTrue("extractMin has problem",smallest<=current);
            smallest = current;
            count++;
        }
        Assert.assertEquals(count,10000000);

    }
}
