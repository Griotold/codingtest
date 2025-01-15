package kundol.week2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 2-C: 안전 영역 - 백준 2468
 * https://www.acmicpc.net/problem/2468
 * DFS, BFS
 * */
public class SafetyArea2468 {

    // 아무 지역도 물에 잠기지 않을 수도 있다.
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    // 물에 잠기지 않는 안전 영역을 조사
    static void dfs(int y, int x, int waterLever) {
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
            if (!visited[ny][nx] && map[ny][nx] > waterLever) {
                dfs(ny, nx, waterLever);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 테스트 케이스
        int answer = 0;
        for (int waterLevel = 0; waterLevel <= 100; waterLevel++) {
            visited = new boolean[N][N];
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > waterLevel && !visited[i][j]) {
                        dfs(i, j, waterLevel);
                        count++;
                    }
                }
            }
            answer = Math.max(answer, count);
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
