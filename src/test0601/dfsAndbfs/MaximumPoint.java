package test0601.dfsAndbfs;

import java.util.*;

public class MaximumPoint {
    // 5 20
    //10 5
    //25 12
    //15 8
    //6 3
    //7 4
    static int result;
    static int n;
    static int timeLimit;
    static Problem[] problems;

    static class Problem {
        int point;
        int time;

        Problem(int point, int time) {
            this.point = point;
            this.time = time;
        }
    }

    static void dfs(int level, int sum, int time) {
        if (time > timeLimit) return;
        if(level == n) {
            result = Math.max(result, sum);
        } else {
            dfs(level + 1, sum + problems[level].point, time + problems[level].time);
            dfs(level + 1, sum, time);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        timeLimit = in.nextInt();
        problems = new Problem[n];
        for (int i = 0; i < n; i++) {
            problems[i] = new Problem(in.nextInt(), in.nextInt());
        }
        dfs(0, 0, 0);
        System.out.println(result);

    }
}
