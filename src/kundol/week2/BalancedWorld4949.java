package kundol.week2;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 2-O : 균형잡힌 세상 - 백준 4949
 * https://www.acmicpc.net/problem/4949
 * 스택
 * */
public class BalancedWorld4949 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        while(true) {
            String str = br.readLine();
            if(str.equals(".")) break;
            Deque<Character> stack = new ArrayDeque<>();
            boolean isBalanced = true;
            for(char ch : str.toCharArray()) {
                if(ch == '(' || ch == '[') {
                    stack.push(ch);
                }
                else if(ch == ')') {
                    if(stack.isEmpty() || stack.peek() != '(') {
                        isBalanced = false;
                        break;
                    }
                    stack.pop();
                }
                else if(ch == ']') {
                    if(stack.isEmpty() || stack.peek() != '[') {
                        isBalanced = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if(!stack.isEmpty()) isBalanced = false;
            sb.append(isBalanced ? "yes" : "no").append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
