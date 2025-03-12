package kundol.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 재귀로 구현하는 조합
 * */
public class Combination {
    static int N;
    static List<Integer> combinations;
    static void combi(int start, int level) {
        if (level == N) {
            for (Integer num : combinations) {
                System.out.print(num);
            }
            System.out.println();
            return;
        }
        for (int i = start; i <= 9; i++) {
            combinations.add(i);
            combi(i + 1, level + 1);
            combinations.remove(combinations.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        combinations = new ArrayList<>();
        combi(0, 0);
        br.close();
    }
}
