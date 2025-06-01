package test0601.dfsAndbfs;

import java.util.*;

public class SequenceGuess {

    static int n;
    static int f;
    static int[] binomial; // 이항계수
    static int[] perm;
    static int[] ch;
    static boolean isEnd;

    static void dfs(int level, int sum) {
        if(isEnd) return;
        if(level == n) {
            if(sum == f) {
                for(int x : perm) System.out.print(x + " ");
                isEnd = true;
            }
        } else {
            for(int i = 1; i <= n; i++) {
                if(ch[i]==0) {
                    ch[i] = 1;
                    perm[level] = i;
                    dfs(level + 1, sum + (perm[level]*binomial[level]));
                    ch[i] = 0;
                }
            }
        }
    }

    static int getBinomialCoeff(int m, int r) {
        if(m == r || r == 0) return 1;
        if(m < r) return 0;

        return getBinomialCoeff(m - 1, r - 1) + getBinomialCoeff(m - 1, r);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        f = in.nextInt();
        perm = new int[n];
        ch = new int[n+1];
        // 1. 이항계수 계산
        binomial = new int[n];
        for(int i = 0 ; i < n; i++) {
            binomial[i] = getBinomialCoeff(n - 1, i);
        }
        dfs(0, 0);
    }
}
