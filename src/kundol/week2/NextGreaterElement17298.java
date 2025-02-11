package kundol.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 2-T : 오큰수 - 백준 17298
 * https://www.acmicpc.net/problem/17298
 * 스택
 * */
public class NextGreaterElement17298 {
    // 4
    // 3 5 2 7
    static int N;
    static int[] arr;
    static int[] ret;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        ret = new int[N];
        Arrays.fill(ret, -1);
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            while (stack.size() > 0 && arr[stack.peek()] < arr[i]) {
                ret[stack.peek()] = arr[i];
                stack.pop();
            }
            stack.push(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(ret[i]).append(" ");
        }
        System.out.println(sb);

        br.close();

    }
}
