package kundol.week1;

import java.io.*;
import java.util.ArrayList;

/**
 * 1-L: 주몽 - 백준 1940
 * https://www.acmicpc.net/problem/1940
 * 재귀함수로 조합 구해서 풀기
 * */
public class Jumong1940_3 {

    static int n, m, cnt = 0;
    static int[] a;

    // 인덱스를 조합으로 뽑는 것
    public static void combi(int idx, ArrayList<Integer> v) {
        if (v.size() == 2) {
            // 조합이 두 개의 원소를 가지면
            int b = a[v.get(0)];
            int c = a[v.get(1)];
            // 두 수의 합이 m이면 카운트 증가
            if (b + c == m) cnt++;
            return ;
        }

        for (int i = idx + 1; i < n; i++) {
            v.add(i); // 현재 인덱스를 추가
            combi(i, v);
            v.remove(v.size() - 1); // 마지막 원소 제거 (백트래킹)
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 처리
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        a = new int[n];
        String[] numbers = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(numbers[i]);
        }

        // 조합 계산 시작
        ArrayList<Integer> v = new ArrayList<>();
        combi(-1, v);

        // 결과 출력
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }
}
