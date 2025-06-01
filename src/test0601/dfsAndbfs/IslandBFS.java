package test0601.dfsAndbfs;

import java.util.*;

public class IslandBFS {

    static final int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static final int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int n;
    static int[][] map;
    static int[][] ch;
    static int result;
    static Deque<Point> queue = new ArrayDeque<>();

    static class Point {
        int y;
        int x;
        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static void bfs() {
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            for(int i = 0 ; i < 8; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
                if(ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
                if(map[ny][nx] == 0) continue;
                if(ch[ny][nx] != 0) continue;
                ch[ny][nx] = 1;
                queue.offer(new Point(ny, nx));
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        map = new int[n][n];
        ch = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && ch[i][j] == 0) {
                    result++;
                    ch[i][j] = 1;
                    queue.offer(new Point(i, j));
                    bfs();
                }
            }
        }
        System.out.println(result);
    }
}
