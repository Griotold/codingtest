package kundol.week2;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 2-N : 괄호 - 백준 9012
 * https://www.acmicpc.net/problem/9012
 * 스택
 * */
public class Parenthesis9012 {
    // 3
    //((
    //))
    //())(()
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(N-- > 0) {
            String str = br.readLine();
            Deque<Character> stack = new ArrayDeque<>();
            for(char ch : str.toCharArray()) {
                if(ch == '(') {
                    stack.push(ch);
                } else {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        stack.push(ch);
                        break;
                    }
                }
            }
            if (stack.isEmpty()) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
