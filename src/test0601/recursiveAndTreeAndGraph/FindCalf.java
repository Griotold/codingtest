package test0601.recursiveAndTreeAndGraph;

import java.util.*;

public class FindCalf {
    // 5 14
    // 3
    static final int[] dx = {1, -1, 5};
    static int n;
    static int m;

    static int bfs(int start, int end) {
        if(start == end) return 0;
        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[10001]; // 충분히 큰 범위
        queue.add(start);
        visited[start] = true;
        int level = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int cur = queue.poll();
                for (int j = 0; j < 3; j++) {
                    int next = cur + dx[j];
                    if (next < 0 || next > 10000) continue; // 범위 체크
                    if (next == end) return level + 1;
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        System.out.println(bfs(n, m));
    }
}
