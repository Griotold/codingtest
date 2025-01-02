package kundol.week1;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 1-H: 수열 - 백준 2559
 * https://www.acmicpc.net/problem/2559
 * 누적합
 * */
public class Sequence2559 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] psum = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            psum[i] = psum[i - 1] + Integer.parseInt(st.nextToken());
        }
        int answer = Integer.MIN_VALUE;
        for (int i = K; i <= N; i++) {
            int cur = psum[i] - psum[i-K];
            answer = Math.max(answer, cur);
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
