package com.wrong.ds.stack;

import org.junit.Test;

public class TestStack {
    @Test
    public void testStack01(){
        Stack<Integer> stack = new Stack<Integer>();
        System.out.println("Before push");
        System.out.println(stack.size());
        System.out.println("After push 88");
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
