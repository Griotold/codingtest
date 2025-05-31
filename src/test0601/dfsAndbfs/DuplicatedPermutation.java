package test0601.dfsAndbfs;

import java.util.*;

public class DuplicatedPermutation {

    static int n;
    static int m;
    static int[] perm;

    static void dfs(int level) {
        if(level == m) {
            for(int a : perm) {
                System.out.print(a + " ");
            }
            System.out.println();
        } else {
            for(int i = 1; i <= n; i++) {
                perm[level] = i;
                dfs(level + 1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        perm = new int[m];
        dfs(0);
    }
}
