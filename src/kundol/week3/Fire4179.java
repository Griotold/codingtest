package kundol.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 3-D : 불! - 백준 4179
 * https://www.acmicpc.net/problem/4179
 * BFS
 * */
public class Fire4179 {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int R, C, ret;
    static char[][] map;
    static int[][] personTime;
    static int[][] fireTime;

    static class Point {
        int y;
        int x;
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        personTime = new int[R][C];
        fireTime = new int[R][C];
        Deque<Point> personQueue = new ArrayDeque<>();
        Deque<Point> fireQueue = new ArrayDeque<>();
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                char temp = line.charAt(j);
                if (temp == 'J') {
                    personQueue.add(new Point(i, j));
                    personTime[i][j] = 1;
                } else if (temp == 'F') {
                    fireQueue.add(new Point(i, j));
                    fireTime[i][j] = 1;
                }
                map[i][j] = temp;
            }
        }

        // 불 확신 시간 기록
        while (!fireQueue.isEmpty()) {
            Point p = fireQueue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
                if (nx < 0 || ny < 0 || ny >= R || nx >= C) continue;
                if (map[ny][nx] == '#') continue;
                if (fireTime[ny][nx] > 0) continue;
                fireTime[ny][nx] = fireTime[p.y][p.x] + 1;
                fireQueue.add(new Point(ny, nx));
            }
        }

        // 지훈 탈출 최단거리
        boolean escaped = false;
        while(!personQueue.isEmpty()) {
            Point p = personQueue.poll();
            // 가장자리에 도달했는지 체크
            if (p.y == 0 || p.y == R-1 || p.x == 0 || p.x == C-1) {
                ret = personTime[p.y][p.x];
                escaped = true;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
                if (nx < 0 || ny < 0 || ny >= R || nx >= C) continue;
                if (map[ny][nx] == '#' ) continue;
                if (personTime[ny][nx] != 0) continue;
                if (fireTime[ny][nx] != 0 && fireTime[ny][nx] <= personTime[p.y][p.x] + 1) continue;
                personTime[ny][nx] = personTime[p.y][p.x] + 1;
                personQueue.add(new Point(ny, nx));
            }
        }

        // 결과 출력
        System.out.println(escaped ? ret : "IMPOSSIBLE");
        br.close();
    }
}
