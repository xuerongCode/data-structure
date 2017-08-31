package com.wrong.al;

import com.wrong.ds.stack.Stack;

public class ArrayAl {
    /**
     * rotate array using intermediate array
     * @param nums
     * @param k
     * @return
     */
    public static void rotate1(int[] nums,int k){
        if(nums == null || k < 0){
            throw new IllegalArgumentException("Illegal Argument");
        }
        k = k % nums.length;
        int[] result = new int[nums.length];

        for(int i=0;i<k;i++){
            result[i] = nums[nums.length-k+i];
        }

        int i=0;
        for(int j=k;j<nums.length;j++){
            result[j] = nums[i++];
        }

        System.arraycopy(result,0,nums,0,nums.length);
    }

    /**
     * rotate array using bubble rotate
     * @param nums
     * @param k
     */
    public static void rotate2(int[] nums, int k){
        if(nums == null || k < 0){
            throw new IllegalArgumentException("Illegal Argument");
        }
        int temp;
        //iterate k times
        for(int i=0;i<k;i++){
            //bubble up current last node to index 0 position
            for(int j=nums.length-1;j>0;j--){
                temp = nums[j];
                nums[j] = nums[j-1];
                nums[j-1] = temp;
            }

        }
    }

    /**
     * rotate array using reversal
     * @param nums
     * @param k
     */
    public static void rotate3(int[] nums, int k){
        if(nums == null || k < 0){
            throw new IllegalArgumentException("Illegal Argument");
        }
        k = k % nums.length;
        reverse(nums,0,nums.length-k-1);
        reverse(nums,nums.length-k,nums.length-1);
        reverse(nums,0,nums.length-1);

    }

    /**
     * reverse array element between left and right
     * @param arr
     * @param left
     * @param right
     */
    public static void reverse(int[] arr, int left, int right){
        if(arr == null || arr.length == 1){
            return;
        }

        int temp;
        while(left < right){
            temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }


    public static int evalRPN1(String[] tokens){
        int result = 0;
        String operator = "+-*/";

        Stack<String> stack = new Stack<String>();

        for (String item : tokens){
            if(!operator.contains(item)){
                stack.push(item);
            }else{
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                switch (item.charAt(0)){
                    case '+':
                        stack.push(String.valueOf(a+b));
                        break;
                    case '-':
                        stack.push(String.valueOf(a-b));
                        break;
                    case '*':
                        stack.push(String.valueOf(a*b));
                        break;
                    case '/':
                        stack.push(String.valueOf(a/b));
                        break;
                }
            }
        }
        result = Integer.valueOf(stack.pop());
        if(stack.size() != 0){
            throw new RuntimeException("Illegal import in evalRPN1");
        }
        return result;
    }
}
