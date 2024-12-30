package kundol.week1;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 1-E: 농구 경기 - 백준 1159
 * https://www.acmicpc.net/problem/1159
 * 구현, 문자열
 * Map
 * */
public class BasketBall1159 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            char ch = name.charAt(0);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        List<Character> list = new ArrayList<>(
                map.entrySet().stream()
                        .filter(e -> e.getValue() >= 5)
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toList()));
        Collections.sort(list);
        for (Character c : list) {
            sb.append(c);
        }

        if (sb.length() == 0) {
            sb.append("PREDAJA");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
