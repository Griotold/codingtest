package kundol.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 3-E: 뮤탈리스크 - 백준 12869
 * https://www.acmicpc.net/problem/12869
 * BFS
 * */
public class Mutalisk12869 {
    public static final int MAX = 61;
    static int N, X, Y, Z, ret;
    static int[][][] visited;
    static int[][] combi = {
            {9, 3, 1},
            {9, 1, 3},
            {3, 9, 1},
            {3, 1, 9},
            {1, 9, 3},
            {1, 3, 9}
    };
    // 3
    // 12 10 4
    static class Point {
        int x;
        int y;
        int z;

        Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new int[MAX][MAX][MAX];
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = N > 1 ? Integer.parseInt(st.nextToken()) : 0;
        Z = N > 2 ? Integer.parseInt(st.nextToken()) : 0;
        visited[X][Y][Z] = 1;
        Deque<Point> queue = new ArrayDeque<>();
        queue.add(new Point(X, Y, Z));
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            // 현재 상태의 공격 횟수
            int cnt = visited[p.x][p.y][p.z];

            if (p.x <= 0 && p.y <= 0 && p.z <= 0) {
                System.out.println(cnt - 1); // 첫 상태를 1로 시작했으므로 1을 빼줌
                break;
            }

            for (int i = 0; i < 6; i++) {
                int nx = Math.max(0, p.x - combi[i][0]);
                int ny = Math.max(0, p.y - combi[i][1]);
                int nz = Math.max(0, p.z - combi[i][2]);
                if (visited[nx][ny][nz] != 0) continue;
                visited[nx][ny][nz] = cnt + 1;
                queue.add(new Point(nx, ny, nz));
            }
        }
        br.close();
    }
}
