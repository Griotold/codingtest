package kundol.week1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1-L: 주몽 - 백준 1940
 * https://www.acmicpc.net/problem/1940
 * 정렬, 이중 반복문, 조합
 * */
public class Jumong1940 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        // 이중 반복문
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = N - 1; j >= 0; j--) {
                if (arr[i] + arr[j] == M) {
                    count++;
                    break;
                }
            }
        }
        count /= 2;
        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
