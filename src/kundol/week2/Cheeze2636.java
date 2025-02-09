package kundol.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 2-Q : 치즈 - 백준 2636
 * https://www.acmicpc.net/problem/2636
 * DFS, BFS
 * */
public class Cheeze2636 {
    static int N, M, times, lastCount;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;
    static List<Point> points;
    // 1. dfs
    // 2. 0 ->
    // 2. 1 -> 자료구조
    // 3. 자료구조 -> 0
    static void dfs(int y, int x) {
        visited[y][x] = true;
        if (map[y][x] == 1) {
            points.add(new Point(y, x));
            return;
        }
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
            if (visited[ny][nx]) continue;
            dfs(ny, nx);
        }
    }

    static class Point {
        private int y;
        private int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while(true) {
            points = new ArrayList<>();
            visited = new boolean[N][M];
            dfs(0, 0);
            lastCount = points.size();
            // 공기중에 닿는 부분 0으로 만들어주기
            for (Point p : points) {
                map[p.getY()][p.getX()] = 0;
            }
            // 시간 ++
            times++;
            // 모두 비었는지 확인
            boolean isEnd = true;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1) {
                        isEnd = false;
                        break;
                    }
                }
                if (!isEnd) break;
            }
            if (isEnd) break;
        }
        System.out.println(times);
        System.out.println(lastCount);
        br.close();
    }
}
