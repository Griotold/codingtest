package test0601.connectwave;

import java.util.*;

public class StackSequence2 {

    public boolean solution(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        int cur = 1;
        for(int num : arr) {

            while(cur <= num) {
                stack.push(cur++);
            }

            if(!stack.isEmpty() && stack.peek() == num) {
                stack.pop();
            } else {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        StackSequence2 stackSequence = new StackSequence2();
        int[] test1 = {3, 1, 2};
        int[] test2 = {1, 3, 2};
        System.out.println("test1 [3, 1, 2]: " + stackSequence.solution(test1)); // false
        System.out.println("test2 [1, 3, 2]: " + stackSequence.solution(test2)); // true
    }
}
