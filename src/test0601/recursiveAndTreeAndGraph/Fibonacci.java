package test0601.recursiveAndTreeAndGraph;

import java.util.*;

public class Fibonacci {

    static int dfs(int num) {
        if(num == 1 || num == 2) return 1;
        else {
            return dfs(num - 1) + dfs(num - 2);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.print(dfs(i) + " ");
        }
    }
}
