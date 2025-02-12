package kundol.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 3-A : 치킨 배달 - 백준 15686
 * https://www.acmicpc.net/problem/15686
 * 완전탐색, DFS
 * */
public class ChickenDistance15686 {
    static int N, M, ret, totalChickenShop;
    static int[][] map;
    static List<Point> chickenStores;
    static List<Point> houses;
    static int[] combinations;

    // 치킨 거리
    static int calculateHomeDistance(Point house) {
        int homDeliveryDistance = Integer.MAX_VALUE;
        for (int i : combinations) {
            homDeliveryDistance = Math.min(homDeliveryDistance,
                    Math.abs(house.getX() - chickenStores.get(i).getX())
                            + Math.abs(house.getY() - chickenStores.get(i).getY()));
        }
        return homDeliveryDistance;
    }
    // 도시의 치킨 거리 = 각 집의 치킨 거리의 합
    static int calculateCityDistance() {
        int cityDeliveryDistance = 0;
        for (Point house : houses) {
            cityDeliveryDistance += calculateHomeDistance(house);
        }
        return cityDeliveryDistance;
    }

    // 조합
    static void combi(int level, int start) {
        if (level == M) {
            ret = Math.min(calculateCityDistance(), ret);
        } else {
            for (int i = start; i < totalChickenShop; i++) {
                combinations[level] = i;
                combi(level + 1, i + 1);
            }
        }
    }
    static class Point {
        private int y;
        private int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        chickenStores = new ArrayList<>();
        houses = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 2) {
                    totalChickenShop++;
                    chickenStores.add(new Point(i, j));
                } else if (temp == 1) {
                    houses.add(new Point(i, j));
                }
                map[i][j] = temp;
            }
        }
        ret = Integer.MAX_VALUE;
        combinations = new int[M];
        combi(0, 0);
        System.out.println(ret);
        br.close();
    }
}
