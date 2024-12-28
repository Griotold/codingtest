package kundol.week1;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 1-C: 트럭주차 - 백준 2979
 * https://www.acmicpc.net/problem/2979
 * 구현
 * */
public class ParkingTruck2979 {
    static int[] truckA = new int[101];
    static int[] truckB = new int[101];
    static int[] truckC = new int[101];
    static int A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        for (int j = start; j < end; j++) {
            truckA[j] = 1;
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        for (int j = start; j < end; j++) {
            truckB[j] = 1;
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        for (int j = start; j < end; j++) {
            truckC[j] = 1;
        }
        int answer = 0;
        for (int i = 1; i <= 100; i++) {
            if (truckA[i] + truckB[i] + truckC[i] == 3) {
                answer += 3 * C;
            } else if (truckA[i] + truckB[i] + truckC[i] == 2) {
                answer += 2 * B;
            } else if (truckA[i] + truckB[i] + truckC[i] == 1) {
                answer += A;
            }
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
