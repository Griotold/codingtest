package kundol.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 2-P : 연구소 - 백준 14502
 * https://www.acmicpc.net/problem/14502
 * DFS, BFS
 */

public class Lab14502 {

    static int[][] a = new int[10][10];
    static int[][] visited = new int[10][10];
    static int n, m, ret;
    static ArrayList<Pair> virusList = new ArrayList<>();
    static ArrayList<Pair> wallList = new ArrayList<>();
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static void dfs(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || ny >= n || nx < 0 || nx >= m || visited[ny][nx] == 1 || a[ny][nx] == 1) continue;
            visited[ny][nx] = 1;
            dfs(ny, nx);
        }
    }

    static int solve() {
        for (int i = 0; i < 10; i++) {
            Arrays.fill(visited[i], 0);
        }

        for (Pair b : virusList) {
            visited[b.first][b.second] = 1;
            dfs(b.first, b.second);
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 0 && visited[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
                if (a[i][j] == 2) virusList.add(new Pair(i, j));
                if (a[i][j] == 0) wallList.add(new Pair(i, j));
            }
        }

        int wallListSize = wallList.size();
        for (int i = 0; i < wallListSize; i++) {
            for (int j = i + 1; j < wallListSize; j++) {
                for (int k = j + 1; k < wallListSize; k++) {
                    Pair wall1 = wallList.get(i);
                    Pair wall2 = wallList.get(j);
                    Pair wall3 = wallList.get(k);

                    a[wall1.first][wall1.second] = 1;
                    a[wall2.first][wall2.second] = 1;
                    a[wall3.first][wall3.second] = 1;

                    ret = Math.max(ret, solve());

                    a[wall1.first][wall1.second] = 0;
                    a[wall2.first][wall2.second] = 0;
                    a[wall3.first][wall3.second] = 0;
                }
            }
        }

        System.out.println(ret);
    }
}
