package test0601.dfsAndbfs;

import java.util.*;

public class ChangeCoin {
    static int result;
    static int n;
    static int m;
    static int[] coins;

    static void dfs(int count, int sum) {
        if(sum > m) return;
        if(sum == m) {
            result = Math.min(count, result);
        } else {
            for(int i = 0; i < n; i++) {
                dfs(count + 1, sum + coins[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        coins = new int[n];
        for(int i = 0 ; i < n ; i++){
            coins[i] = in.nextInt();
        }
        m = in.nextInt();
        result = Integer.MAX_VALUE;
        dfs(0, 0);
        System.out.println(result);
    }
}
