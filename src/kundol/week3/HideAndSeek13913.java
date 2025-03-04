package kundol.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 3-H: 숨박꼭질 4 - 백준 13913
 * https://www.acmicpc.net/problem/13913
 * BFS
 * */
public class HideAndSeek13913 {
    // 5 17
    // 4
    // 4
    // 5 10 9 18 17 또는 5 4 8 16 17
    static final int MAX = 200_004;
    static int ret, N, M;
    static int[] dx = {1, -1, 2};
    static int[] visited;
    static int[] parent;
    static List<Integer> traces;

    static void bfs(int start) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        parent[start] = -1;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == M) {
                ret = visited[cur];
                break;
            }
            int next;
            for (int i = 0; i < 3; i++) {
                if (dx[i] == 2) {
                    next = cur * 2;
                } else {
                    next = cur + dx[i];
                }
                if (next < 0 || next >= MAX) continue;
                if (visited[next] != 0) continue;
                visited[next] = visited[cur] + 1;
                queue.add(next);
                parent[next] = cur;
            }
        }
        traces = new ArrayList<>();
        for (int i = M; i != N; i = parent[i]) {
            traces.add(i);
        }
        traces.add(N);
        Collections.reverse(traces);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new int[MAX];
        parent = new int[MAX];
        bfs(N);
        System.out.println(ret);
        for (int trace : traces) {
            System.out.print(trace + " ");
        }
        System.out.println();
        br.close();
    }
}
