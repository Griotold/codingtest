package kundol.week1;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 1-C: 트럭주차 - 백준 2979
 * https://www.acmicpc.net/problem/2979
 * times 라는 하나의 배열로 카운팅하기
 * */
public class ParkingTruck2979_2 {
    static int A, B, C;
    static int[] times = new int[104];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            // 도착 시간 ~ 떠난 시간은 항상 "이상 ~ 미만"
            for (int j = start; j < end; j++) {
                times[j]++;
            }
        }

        int answer = 0;
        for (int i = 1; i <= 100; i++) {
            if (times[i] == 1) {
                answer += A;
            } else if (times[i] == 2) {
                answer += 2 * B;
            } else if (times[i] == 3) {
                answer += 3 * C;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
