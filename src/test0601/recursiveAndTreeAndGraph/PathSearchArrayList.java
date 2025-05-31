package test0601.recursiveAndTreeAndGraph;

import java.util.*;

public class PathSearchArrayList {
    static int n;
    static int m;
    static int result;
    static List<List<Integer>> graph;
    static int[] ch;

    static void dfs(int v) {
        if (v == n) result++;
        else {
            for (int nv: graph.get(v)) {
                if (ch[nv] == 0) {
                    ch[nv] = 1;
                    dfs(nv);
                    ch[nv] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        ch = new int[n+1];
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        ch[1] = 1;
        dfs(1);
        System.out.println(result);
    }
}
