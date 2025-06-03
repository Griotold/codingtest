package test0601.connectwave;

import java.util.*;

public class KeyboardDistanceSum2 {

    static class Position {
        int row;
        int col;
        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static final String[] KEYBOARD = {
            "qwertyuiop",
            "asdfghjkl",
            "zxcvbnm",
    };

    static Map<Character, Position> charToPos = new HashMap<>();

    static {
        for(int i = 0 ; i < KEYBOARD.length ; i++) {
            for (int j = 0; j < KEYBOARD[i].length(); j++) {
                char c = KEYBOARD[i].charAt(j);
                charToPos.put(c, new Position(i, j));
            }
        }
    }

    static int manhattanDist(char a, char b) {
        Position posA = charToPos.get(a);
        Position posB = charToPos.get(b);
        return Math.abs(posA.row - posB.row) + Math.abs(posA.col - posB.col);
    }

    static int substringDistance(String s) {
        int sum = 0;
        for(int i = 0; i < s.length() - 1; i++) {
            sum += manhattanDist(s.charAt(i), s.charAt(i+1));
        }
        return sum;
    }

    int solution(String s) {
        int total = 0;
        int n = s.length();
        for(int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                String substr = s.substring(i, i + len);
                total += substringDistance(substr);
            }
        }
        return total;
    }

    public static void main(String[] args) {
        KeyboardDistanceSum solver = new KeyboardDistanceSum();
        System.out.println(solver.solution("abcc")); // 출력: 23
    }
}
