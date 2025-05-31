package test0601.dfsAndbfs;

import java.util.*;

public class BoardingBadoogi {
    static int result;
    static int c;
    static int n;
    static int[] dogs;
    static void dfs(int level, int sum) {
        if(sum > c) return; // 이미 초과하면 더 이상 탐색 안 함
        if(level == n) {
            result = Math.max(result, sum);
        } else {
            dfs(level + 1, sum + dogs[level]);
            dfs(level + 1, sum);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        c = in.nextInt();
        n = in.nextInt();
        dogs = new int[n];
        for(int i = 0 ; i < n ; i++) {
            dogs[i] = in.nextInt();
        }
        dfs(0, 0);
        System.out.println(result);
    }
}
