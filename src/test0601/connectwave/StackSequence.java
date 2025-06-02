package test0601.connectwave;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 첫 번째 문제
 * 백준 1874 - 스택 수열과 유사
 * https://www.acmicpc.net/problem/1874
 * */
public class StackSequence {

    public boolean solution(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        int current = 1; // 1부터 순서대로 push할 값
        for (int num : arr) {
            // 현재 값이 num보다 작거나 같으면 계속 push
            while (current <= num) {
                stack.push(current);
                current++;
            }
            // 스택의 top이 num과 같으면 pop
            if (!stack.isEmpty() && stack.peek() == num) {
                stack.pop();
            } else {
                return false; // 불가능
            }
        }
        return true;
    }

    public static void main(String[] args) {
        StackSequence stackSequence = new StackSequence();
        int[] test1 = {3, 1, 2};
        int[] test2 = {1, 3, 2};
        System.out.println("test1 [3, 1, 2]: " + stackSequence.solution(test1)); // false
        System.out.println("test2 [1, 3, 2]: " + stackSequence.solution(test2)); // true
    }
}
