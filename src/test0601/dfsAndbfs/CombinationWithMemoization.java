package test0601.dfsAndbfs;

import java.util.*;

public class CombinationWithMemoization {
    static int[][] dp = new int[35][35];

    static int dfs(int n, int m) {
        if(dp[n][m] > 0) return dp[n][m];
        if (m == 0 || m == n) return 1;
        if (m > n) return 0;

        return dp[n][m] = dfs(n - 1, m - 1) + dfs(n - 1, m);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        System.out.println(dfs(n, m));
    }
}
