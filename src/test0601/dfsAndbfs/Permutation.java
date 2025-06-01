package test0601.dfsAndbfs;

import java.util.*;

public class Permutation {

    static int n;
    static int m;
    static int[] arr;
    static int[] ch;
    static int[] perm;

    static void dfs(int level) {
        if(level == m) {
            for(int a : perm) System.out.print(a + " ");
            System.out.println();
        } else {
            for(int i = 0 ; i < n; i++) {
                if(ch[i] == 0) {
                    ch[i] = 1;
                    perm[level] = arr[i];
                    dfs(level + 1);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        ch = new int[n];
        perm = new int[m];
        for(int i = 0 ; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        dfs(0);
    }
}
