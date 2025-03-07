package kundol.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 3-L: 알파벳 - 백준 1987
 * https://www.acmicpc.net/problem/1987
 * DFS, 완전탐색
 * */
public class Alphabet1987 {
    static int R, C, ret;
    static int[] visited;
    static char[][] map;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static void dfs(int y, int x, int cnt) {
        ret = Math.max(ret, cnt);
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
            int next = map[ny][nx] - 'A';

            if (visited[next] == 0) {
                visited[next] = 1;
                dfs(ny, nx, cnt + 1);
                visited[next] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        visited = new int[30];
        map = new char[21][21];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        visited[map[0][0] - 'A'] = 1;
        dfs(0, 0, 1);
        System.out.println(ret);
        br.close();
    }
}
