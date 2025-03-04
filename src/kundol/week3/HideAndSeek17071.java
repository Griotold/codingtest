package kundol.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 3-I: 숨박꼭질 5 - 백준 17071
 * https://www.acmicpc.net/problem/17071
 * BFS
 * */
public class HideAndSeek17071 {
    static final int MAX_N = 500_000;
    static int[][] visited = new int[2][MAX_N + 4];
    static int N, K, turn = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            return;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        visited[0][N] = 1; // 시작 위치 방문 체크
        queue.add(N);

        boolean found = false;

        while (!queue.isEmpty()) {
            K += turn; // 동생의 위치 업데이트
            if (K > MAX_N) break; // 범위를 넘는 경우 종료

            // 현재 레벨에서 동생의 위치가 이미 방문된 경우
            if (visited[turn % 2][K] > 0) {
                found = true;
                break;
            }

            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                int x = queue.poll();

                // 가능한 다음 위치 탐색
                for (int nx : new int[]{x + 1, x - 1, x * 2}) {
                    if (nx < 0 || nx > MAX_N || visited[turn % 2][nx] > 0) continue;

                    visited[turn % 2][nx] = visited[(turn + 1) % 2][x] + 1; // 방문 체크
                    if (nx == K) {
                        found = true;
                        break;
                    }
                    queue.add(nx);
                }

                if (found) break;
            }

            if (found) break;
            turn++;
        }

        System.out.println(found ? turn : -1);
    }
}
