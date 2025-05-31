package test0601.recursiveAndTreeAndGraph;

import java.util.*;

public class SubSet {
    static int n;
    static int[] ch;

    static void dfs(int level) {
        if(level == n + 1) {
            String tmp = "";
            for(int i = 1; i <= n; i++) {
                if(ch[i]==1) tmp += (i+" ");
            }
            if (tmp.length() > 0) System.out.println(tmp);
        } else {
            ch[level] = 1;
            dfs(level + 1);
            ch[level] = 0;
            dfs(level + 1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ch = new int[n + 1];
        dfs(1);
    }
}
