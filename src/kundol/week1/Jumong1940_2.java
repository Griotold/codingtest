package kundol.week1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1-L: 주몽 - 백준 1940
 * https://www.acmicpc.net/problem/1940
 * 정렬, 투포인터
 * */
public class Jumong1940_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 재료의 개수
        int M = Integer.parseInt(br.readLine()); // 갑옷을 만드는 데 필요한 번호의 합
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 정렬
        Arrays.sort(arr);

        // 투 포인터 초기화
        int left = 0;
        int right = N - 1;
        int count = 0;

        // 투 포인터 탐색
        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum < M) {
                left++; // 합이 작으면 left 증가
            } else if (sum > M) {
                right--; // 합이 크면 right 감소
            } else { // sum == M
                count++;
                left++;
                right--;
            }
        }

        // 결과 출력
        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
