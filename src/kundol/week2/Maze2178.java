package kundol.week2;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 2-A : 미로 탐색 - 백준 2178
 * https://www.acmicpc.net/problem/2178
 * 그래프, BFS
 * */
public class Maze2178 {
    static int N, M;
    static int[][] maze;
    static int[][] distance;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N][M];
        distance = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = Character.getNumericValue(line.charAt(j)); // 수정된 부분
            }
        }
        // (0,0) -> (3,5)
        Deque<Point> queue = new ArrayDeque<>();
        queue.add(new Point(0, 0));
        visited[0][0] = true;
        distance[0][0] = 1;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int cy = point.getY();
            int cx = point.getX();
            if (cy == N - 1 && cx == M - 1) {
                break;
            }
            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                if (maze[ny][nx] == 0 || visited[ny][nx]) continue;
                // 범위 안에 들어 있고, 이동할 수 있는 칸(1)
                queue.add(new Point(ny, nx));
                visited[ny][nx] = true;
                distance[ny][nx] = distance[cy][cx] + 1;
            }
        }
        bw.write(distance[N - 1][M - 1] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Point {
        int y;
        int x;

        Point(int y, int x) {
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
}
