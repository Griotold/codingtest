package kundol.week2;

import java.io.*;

/**
 * 2-K : 교수가 된 현우 - 백준 3474
 * https://www.acmicpc.net/problem/3474
 * 수학, 정수론
 * */
public class ProfessorHyunwoo3474 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            int current = Integer.parseInt(br.readLine());
            int twoCount = 0;
            int fiveCount = 0;
            for (int i = 2; i <= current; i = i * 2) {
                int value = current / i;
                twoCount += value;
            }
            for (int i = 5; i <= current; i = i * 5) {
                int value = current / i;
                fiveCount += value;
            }
            int tenCount = 0;
            tenCount = Math.min(twoCount, fiveCount);
            sb.append(tenCount).append("\n");
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
