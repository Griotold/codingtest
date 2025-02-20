package kundol.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 3-B : 보물섬 - 백준 2589
 * https://www.acmicpc.net/problem/2589
 * BFS
 * */
public class TreasureIsland2589 {
    static int N, M, ret;
    static int[][] map;
    static int[][] distances;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

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

    static void bfs(int y, int x) {
        visited[y][x] = true;
        Deque<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(y, x));
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = point.getY() + dy[i];
                int nx = point.getX() + dx[i];
                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if (visited[ny][nx]) continue;
                if (map[ny][nx] == 0) continue;
                visited[ny][nx] = true;
                queue.offer(new Point(ny, nx));
                distances[ny][nx] = distances[point.getY()][point.getX()] + 1;
            }
        }
    }

    // 1. 'L' 인 부분은 모두 최단거리를 구해버린다.
    // 2. 최단거리가 최대가 되는 곳
    private static int getMaxValue() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int cur = distances[i][j];
                max = Math.max(max, cur);
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                // W는 0으로, L은 1로 변환
                map[i][j] = line.charAt(j)  == 'W' ? 0 : 1;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    distances = new int[N][M];
                    visited = new boolean[N][M];
                    bfs(i, j);
                    ret = Math.max(getMaxValue(), ret);
                }
            }
        }

        System.out.println(ret);

        br.close();
    }
}
