package test0601.recursiveAndTreeAndGraph;

import java.util.*;

public class PathSearchMatrix {

    static final int MAX = 21;
    static int n;
    static int m;
    static int result;
    static int[][] matrix;
    static int[] visited;
    // 5 9
    //1 2
    //1 3
    //1 4
    //2 1
    //2 3
    //2 5
    //3 4
    //4 2
    //4 5
    // 6
    static void dfs(int node) {
        visited[node] = 1;
        if (node == n) result++;
        else {
            for(int i = 1; i <= n; i++) {
                if (visited[i] == 0 && matrix[node][i] == 1) {
                    visited[i] = 1;
                    dfs(i);
                    visited[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        matrix = new int[MAX][MAX];
        visited = new int[MAX];
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            matrix[a][b] = 1;
        }

        dfs(1);
        System.out.println(result);
    }
}
