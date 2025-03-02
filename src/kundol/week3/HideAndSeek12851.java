package kundol.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 3-G: 숨박꼭질2 - 백준 12851
 * https://www.acmicpc.net/problem/12851
 * BFS
 * */
public class HideAndSeek12851 {
    static final int MAX = 100_004;
    static int N, M, ret, count;
    static int[] visited;
    static int[] dx = {1, -1, 2};
    // 5 17
    // 4 - 최소거리
    // 2 - 가짓수
    static void bfs(int start) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == M) {
                if (ret == 0) ret = visited[cur];
                if (ret == visited[cur]) count++;
                continue;
            }
            if (ret > 0 && visited[cur] >=  ret) continue;
            for (int i = 0; i < 3; i++) {
                int next;
                if (dx[i] == 2) {
                    next = cur * 2;
                } else {
                    next = cur + dx[i];
                }
                if (next < 0 || next >= MAX) continue;
                if (visited[next] == 0 || visited[next] == visited[cur] + 1) {
                    visited[next] = visited[cur] + 1;
                    queue.add(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new int[MAX];
        bfs(N);
        System.out.println(ret);
        System.out.println(count);
        br.close();
    }

}
