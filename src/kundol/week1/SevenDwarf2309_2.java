package kundol.week1;

import java.io.*;
import java.util.Arrays;

/**
 * 1-A : 일곱 난쟁이
 * https://www.acmicpc.net/problem/2309
 * 브루트포스, 정렬
 * 재귀 - 순열
 */
public class SevenDwarf2309_2 {
    static int[] a = new int[9];
    static int n = 9;
    static int r = 7;

    static void makePermutation(int n, int r, int depth) {
        if (r == depth) {
            solve();
            return;
        }
        for (int i = depth; i < n; i++) {
            swap(a, i, depth);
            makePermutation(n, r, depth + 1);
            swap(a, i, depth);
        }
    }
    static void solve() {
        int sum = 0;

        // 앞에서 r개(7개)의 합 계산
        for (int i = 0; i < r; i++) {
            sum += a[i];
        }

        // 합이 100인 경우 결과 출력
        if (sum == 100) {
            java.util.Arrays.sort(a, 0, r); // 앞에서 r개만 정렬
            for (int i = 0; i < r; i++) {
                System.out.println(a[i]);
            }
            System.exit(0); // 프로그램 종료
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        makePermutation(n, r, 0);


        bw.flush();
        bw.close();
        br.close();
    }
}
