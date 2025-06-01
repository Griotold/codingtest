package test0601.dfsAndbfs;

import java.util.*;

public class Tomato {
    static int n;
    static int m;
    static int[][] board;
    static int[][] ch;
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};
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
            Point cur = queue.poll();
            for(int i = 0 ; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if(board[ny][nx] == -1 || board[ny][nx] == 1) continue;
                board[ny][nx] = 1;
                ch[ny][nx] = ch[cur.y][cur.x] + 1;
                queue.offer(new Point(ny, nx));
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        board = new int[n][m];
        ch = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
                if(board[i][j] == 1) queue.offer(new Point(i, j));
            }
        }
        bfs();
        boolean flag = true;
        int answer = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i ++) {
            if(flag == false) break;
            for(int j = 0 ; j < m ; j++) {
                if(board[i][j] == 0) {
                    flag = false;
                    break;
                }
            }
        }
        if(flag) {
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    answer=Math.max(answer, ch[i][j]);
                }
            }
            System.out.println(answer);
        } else System.out.println(-1);
    }
}
