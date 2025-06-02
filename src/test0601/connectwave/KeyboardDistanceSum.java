package test0601.connectwave;

import java.util.*;
/**
 * 다섯 번째 문제
 * 백준 11478번: 서로 다른 부분 문자열의 개수 https://www.acmicpc.net/problem/11478
 * 백준 10942번: 팰린드롬? https://www.acmicpc.net/problem/10942
 * 백준: LCS https://www.acmicpc.net/problem/9251
 * */

public class KeyboardDistanceSum {
    private static class Position {
        int row;
        int col;
        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private static final String[] KEYBOARD = {
            "qwertyuiop",
            "asdfghjkl",
            "zxcvbnm"
    };

    private static Map<Character, Position> charToPos = new HashMap<>();

    static {
        for (int i = 0; i < KEYBOARD.length; i++) {
            for (int j = 0; j < KEYBOARD[i].length(); j++) {
                char c = KEYBOARD[i].charAt(j);
                charToPos.put(c, new Position(i, j));
            }
        }
    }

    // 두 문자의 맨해튼 거리 계산
    private static int manhattanDist(char a, char b) {
        Position posA = charToPos.get(a);
        Position posB = charToPos.get(b);
        return Math.abs(posA.row - posB.row) + Math.abs(posA.col - posB.col);
    }

    // 부분 문자열의 이동 거리 합 계산
    private static int substringDistance(String s) {
        int sum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            sum += manhattanDist(s.charAt(i), s.charAt(i + 1));
        }
        return sum;
    }

    public int solution(String s) {
        int total = 0;
        int n = s.length();
        // 모든 연속된 부분 문자열(길이 2 이상)에 대해
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                String substr = s.substring(i, i + len);
                total += substringDistance(substr);
            }
        }
        return total;
    }

    // 테스트 코드
    public static void main(String[] args) {
        KeyboardDistanceSum solver = new KeyboardDistanceSum();
        System.out.println(solver.solution("abcc")); // 출력: 23
    }
}
