package test0601.dfsAndbfs;

import java.util.*;

public class IslandDFS {
    static final int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static final int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int n;
    static int[][] map;
    static int[][] ch;
    static int result;

    static void dfs(int y, int x) {
        for(int i = 0 ; i < 8; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
            if(map[ny][nx] == 0) continue;
            if(ch[ny][nx] == 1) continue;
            ch[ny][nx] = 1;
            dfs(ny, nx);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        map = new int[n][n];
        ch = new int[n][n];
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                map[i][j] = in.nextInt();
            }
        }
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(map[i][j] == 1 && ch[i][j] == 0) {
                    result++;
                    ch[i][j] = 1;
                    dfs(i, j);
                }
            }
        }
        System.out.println(result);
    }

}
