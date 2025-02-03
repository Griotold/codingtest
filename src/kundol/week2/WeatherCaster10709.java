package kundol.week2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 2-J : 기상캐스터 - 백준 10709
 * https://www.acmicpc.net/problem/10709
 * 구현, 시뮬레이션
 * */
public class WeatherCaster10709 {
    //3 4
    //c..c
    //..c.
    //....
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[][] map = new int[H][W];
        // -1로 초기화
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                map[i][j] = -1;
            }
        }
        for (int i = 0; i < H; i++) {
            String str = br.readLine();
            int cnt = 1;
            boolean isPossible = false;
            for (int j = 0; j < W; j++) {
                char ch = str.charAt(j);
                if(ch == 'c') {
                    map[i][j] = 0;
                    cnt = 1;
                    isPossible = true;
                } else {
                    if (isPossible) {
                        map[i][j] = cnt++;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}
