package kundol.week1;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1-M: 좋은 단어 - 백준 3986
 * https://www.acmicpc.net/problem/3986
 * 스택
 * */
public class GoodWord3986 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        while(N-- > 0) {
            String word = br.readLine();
            Deque<Character> stack = new ArrayDeque<>();
            for(char c : word.toCharArray()) {
                if (!stack.isEmpty()) {
                    if (c == stack.peek()) stack.pop();
                    else stack.push(c);
                } else {
                    stack.push(c);
                }
            }
            if (stack.isEmpty()) count++;
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
