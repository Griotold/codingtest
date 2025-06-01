package test0601.dfsAndbfs;

import java.util.*;

public class Combination {
    static int n;
    static int m;
    static int[] coms;

    static void dfs(int level, int start) {
        if(level == m) {
            for(int a : coms) System.out.print(a + " ");
            System.out.println();
        } else {
            for(int i = start; i <= n; i++) {
                coms[level] = i;
                dfs(level + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        coms = new int[m];
        dfs(0, 1);
    }
}
