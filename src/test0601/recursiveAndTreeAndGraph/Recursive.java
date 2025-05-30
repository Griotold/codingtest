package test0601.recursiveAndTreeAndGraph;

import java.util.*;

public class Recursive {
    // 3
    // 1 2 3
    /**
     * 전위 순회
     * */
    static void dfs(int n, int level) {
        if(level == n + 1) {
            return;
        } else {
            System.out.print(level + " ");
            dfs(n, level + 1);
        }
    }

    /**
     * 후위 순회
     * */
    static void dfs(int n) {
        if (n == 0) return;
        else {
            dfs(n-1);
            System.out.print(n + " ");
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dfs(n, 1);
    }
}
