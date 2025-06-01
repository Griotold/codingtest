package test0601.dfsAndbfs;

import java.util.*;

public class MazeSortestPathFinder {
    static final int SIZE = 7;
    static final int[][] maze = new int[SIZE][SIZE];
    static final int[][] ch = new int[SIZE][SIZE];
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};

    static class Point {
        int y;
        int x;
        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static int bfs(int y, int x) {
        Deque<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(y, x));
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for(int j = 0; j < 4; j++) {
                int ny = cur.y + dy[j];
                int nx = cur.x + dx[j];
                if(ny < 0 || nx < 0 || ny >= SIZE || nx >= SIZE) continue;
                if(maze[ny][nx] == 1) continue;
                if(ch[ny][nx] != 0) continue;
                ch[ny][nx] = ch[cur.y][cur.x] + 1;
                queue.offer(new Point(ny, nx));
            }
        }
        return ch[SIZE - 1][SIZE - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        System.out.println(bfs(0, 0));
    }
}
