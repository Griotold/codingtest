package test0601.dfsAndbfs;

import java.util.*;

public class MazeSearch {
    static final int SIZE = 7;
    static final int[][] maze = new int[SIZE][SIZE];
    static final int[][] ch = new int[SIZE][SIZE];
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};
    static int result;

    static void dfs(int y, int x) {
        if(y == SIZE - 1 && x == SIZE - 1) {
            result++;
        } else {
            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || nx < 0) continue;
                if(ny >= SIZE || nx >= SIZE) continue;
                if(maze[ny][nx] == 1) continue;
                if (ch[ny][nx] == 1) continue;
                ch[ny][nx] = 1;
                dfs(ny, nx);
                ch[ny][nx] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0 ; i < SIZE ; i++){
            for(int j = 0 ; j < SIZE ; j++){
                maze[i][j] = sc.nextInt();
            }
        }
        ch[0][0] = 1;
        dfs(0, 0);
        System.out.println(result);
    }
}
