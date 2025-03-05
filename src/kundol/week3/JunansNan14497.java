package kundol.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 3-J: 주난의 난 - 백준 14497
 * https://www.acmicpc.net/problem/14497
 * BFS
 * */
public class JunansNan14497 {
    static final int MAX = 304;
    static char[][] map;
    static int N, M, y1, x1, y2, x2, ret;
    static int[][] visited;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    // 5 7
    //3 4 1 2
    //1#10111
    //1101001
    //001*111
    //1101111
    //0011001

    // 0을 만나면 계속 탐색, 1을 만나면 카운트
    // queue 를 두 개 사용한다

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
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        y1 = Integer.parseInt(st.nextToken()) - 1;
        x1 = Integer.parseInt(st.nextToken()) - 1;
        y2 = Integer.parseInt(st.nextToken()) - 1;
        x2 = Integer.parseInt(st.nextToken()) - 1;
        map = new char[MAX][MAX];
        visited = new int[MAX][MAX];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        Deque<Point> queue = new ArrayDeque<>();
        queue.add(new Point(y1, x1));
        visited[y1][x1] = 1;
        int cnt = 0;
        while (map[y2][x2] != '0') {
            cnt++;
            Deque<Point> temp = new ArrayDeque<>();
            while (!queue.isEmpty()) {
                int y = queue.peek().y;
                int x = queue.peek().x;
                queue.pop();
                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if (ny < 0 ||  ny >= N || nx < 0 || nx >= M) continue;
                    if (visited[ny][nx] > 0) continue;
                    visited[ny][nx] = cnt;
                    if (map[ny][nx] != '0') {
                        map[ny][nx] = '0';
                        temp.push(new Point(ny, nx));
                    } else {
                        queue.add(new Point(ny, nx));
                    }
                }
            }
            queue = temp;
        }

        System.out.println(visited[y2][x2]);
        br.close();
    }
}
