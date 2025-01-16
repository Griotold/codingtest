package kundol.week2;

import javax.swing.text.View;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 2-D: 영역 구하기 - 백준 2583
 * https://www.acmicpc.net/problem/2583
 * DFS, BFS
 * int 반환 DFS
 * */
public class CalculateArea2583 {
    static int N, M, K;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] map;
    static int[][] visited;
    static List<Integer> result;

    // int 반환 DFS
    static int dfs(int y, int x) {
        visited[y][x] = 1;
        int ret = 1;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || ny >= M || nx < 0 || nx >= N || visited[ny][nx] == 1) continue;
            if (map[ny][nx] == 1) continue;
            ret += dfs(ny, nx);
        }
        return ret;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visited = new int[M][N];
        // 직사각형 색칠하기
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    map[y][x] = 1;
                }
            }
        }
        result = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 1 && visited[i][j] == 0) {
                    result.add(dfs(i, j));
                }
            }
        }
        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for (Integer i : result) {
            sb.append(i).append(" ");
        }
        sb.append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
