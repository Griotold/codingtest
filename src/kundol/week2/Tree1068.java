package kundol.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 2-R : 트리 - 백준 1068
 * https://www.acmicpc.net/problem/1068
 * DFS
 * */
public class Tree1068 {

    static int N;
    static int R;
    static int temp;
    static int root;
    static List<List<Integer>> adj;

    static int dfs(int here) {
        int ret = 0;
        int child = 0;
        for (int there : adj.get(here)) {
            if (there == R) continue;
            ret += dfs(there);
            child++;
        }
        if (child == 0) return 1;
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            temp = Integer.parseInt(st.nextToken());
            if (temp == -1) root = i;
            else adj.get(temp).add(i);
        }

        R = Integer.parseInt(br.readLine());

        if (R == root) {
            System.out.println("0\n");
        } else {
            System.out.println(dfs(root) + "\n");
        }
        br.close();
    }
}
