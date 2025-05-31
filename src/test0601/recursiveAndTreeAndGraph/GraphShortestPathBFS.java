package test0601.recursiveAndTreeAndGraph;

import java.util.*;

public class GraphShortestPathBFS {
    // 6 9
    //1 3
    //1 4
    //2 1
    //2 5
    //3 4
    //4 5
    //4 6
    //6 2
    //6 5
    // ---
    // 2 : 3
    //3 : 1
    //4 : 1
    //5 : 2
    //6 : 2
    static int n;
    static int m;
    static int result;
    static int[][] graph;
    static boolean[] visited;

    static void bfs(int start, int end) {
        visited[start] = true;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        int level = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int here = queue.poll();
                if(here == end) {
                    System.out.println(end + " : " + level);
                }
                for(int j = 1; j <= n; j++) {
                    if(graph[here][j] == 1 && visited[j] == false) {
                        visited[j] = true;
                        queue.add(j);
                    }
                }
            }
            level++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new int[n+1][n+1];

        for(int i = 0 ; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
        }

        for(int i = 2; i <= n; i++) {
            visited = new boolean[n+1];
            bfs(1, i);
        }
    }
}
