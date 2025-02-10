package kundol.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 2-S : 효율적인 해킹 - 백준 1325
 * https://www.acmicpc.net/problem/1325
 * DFS, BFS
 * */
public class EfficientHacking1325 {

    static int N, M;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] counts;
    static boolean[] visited;

    static int dfs(int computer) {
        visited[computer] = true;
        int ret = 1;
        for (int next : graph.get(computer)) {
            if (visited[next]) continue;
                ret += dfs(next);
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(b).add(a);
        }
        counts = new int[N+1];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N+1];
            counts[i] = dfs(i);
            max = Math.max(max, counts[i]);
        }
        for (int i = 1; i <= N; i++) {
            if (counts[i] == max) System.out.print(i + " ");
        }
        br.close();
    }
}
