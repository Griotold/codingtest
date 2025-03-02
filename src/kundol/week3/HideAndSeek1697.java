package kundol.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 번외: 숨박꼭질 - 백준 1697
 * https://www.acmicpc.net/problem/1697
 * BFS
 * */
public class HideAndSeek1697 {
    // 5 17 -> 4
    static final int MAX = 100_004;
    static int N, M, ret;
    static int[] dx = {1, -1, 2};
    static int[] visited;
    static void bfs(int start) {
        visited[start] = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == M) {
                ret = visited[cur];
                break;
            }
            for (int i = 0; i < 3; i++) {
                int next;
                if (dx[i] == 2) {
                    next = cur * 2;
                } else {
                    next = cur + dx[i];
                }
                if (next < 0 || next >= MAX) continue;
                if (visited[next] != 0) continue;
                visited[next] = visited[cur] + 1;
                queue.add(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ret = 0;
        visited = new int[MAX];
        bfs(N);
        System.out.println(ret);
        br.close();
    }
}
