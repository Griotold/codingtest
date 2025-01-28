package kundol.week2;

import java.io.*;

/**
 * 2-E: 쿼드트리 - 백준 1992
 * https://www.acmicpc.net/problem/1992
 * 분할정복, 재귀
 * */
public class QuadTree1992 {
    static int N;
    static char[][] image;

    static String quard(int y, int x, int size) {
        // 현재 영역의 첫 번째 값을 기준으로 설정
        char base = image[y][x];

        // 현재 영역이 모두 같은 값인지 확인
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (image[i][j] != base) { // 다른 값이 발견되면 분할
                    StringBuilder sb = new StringBuilder();
                    sb.append('(');
                    int half = size / 2;
                    sb.append(quard(y, x, half));               // 왼쪽 위
                    sb.append(quard(y, x + half, half));        // 오른쪽 위
                    sb.append(quard(y + half, x, half));        // 왼쪽 아래
                    sb.append(quard(y + half, x + half, half)); // 오른쪽 아래
                    sb.append(')');
                    return sb.toString();
                }
            }
        }

        // 모든 값이 동일하면 해당 값을 반환
        return String.valueOf(base);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        image = new char[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                // '1' 을 1로 저장하기 위한 로직
                image[i][j] = str.charAt(j);
            }
        }

        String result = quard(0, 0, N); // (0, 0)부터 시작하여 전체 크기 N을 처리
        bw.write(result);

        bw.flush();
        bw.close();
        br.close();
    }
}
