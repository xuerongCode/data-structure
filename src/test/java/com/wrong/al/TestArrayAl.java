package com.wrong.al;

import org.junit.Test;

public class TestArrayAl {
    @Test
    public void testRotate1(){
        int[] array = {1,3,4,5,6,7,8};

        ArrayAl.rotate1(array,array.length-1);

        for (int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }

    }

    @Test
    public void testRotate2(){
        int[] array = {1,2,3,4,5,6};

        ArrayAl.rotate2(array,13);

        for (int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }

    }

    @Test
    public void testRotate3(){
        int[] array = {1,2,3,4,5,6};

        ArrayAl.rotate3(array,6);

        for (int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }

    }

    @Test
    public void testevalRPN1(){
        String[] tokens = new String[] { "2", "1", "+", "3", "/" };
        System.out.println(ArrayAl.evalRPN1(tokens));
    }
}
