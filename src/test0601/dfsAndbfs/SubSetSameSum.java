package test0601.dfsAndbfs;

import java.util.*;

public class SubSetSameSum {
    // 6
    //1 3 5 6 7 10
    // YES
    static String result;
    static int total;
    static int n;
    static int[] nums;
    static int[] ch;
    static void dfs(int level, int sum) {
        if ("YES".equals(result)) return;
        if(level == n) {
            if(total - sum == sum) {
                result = "YES";
            }
        } else {
            dfs(level + 1, sum + nums[level]);
            dfs(level + 1, sum);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        nums = new int[n];
        ch = new int[n];
        for(int i = 0 ; i < n ; i++) {
            nums[i] = sc.nextInt();
            total += nums[i];
        }
        result = "NO";
        dfs(0, 0);
        System.out.println(result);
    }

}
