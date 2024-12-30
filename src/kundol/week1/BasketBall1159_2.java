package kundol.week1;

import java.io.*;

/**
 * 1-E: 농구 경기 - 백준 1159
 * https://www.acmicpc.net/problem/1159
 * 구현, 문자열
 * counting array
 * */
public class BasketBall1159_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[26];
        int n = Integer.parseInt(br.readLine());  //선수의 수
        boolean possible = false;  //다섯 명을 선발할 수 있는지
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            char c = name.charAt(0);  //첫 글자
            arr[c - 97]++;  //아스키 코드 이용
            if (arr[c - 97] == 5) possible = true;  //5명이 되면 5명을 선발할 수 있다
        }
        StringBuilder sb = new StringBuilder();
        if (possible) {
            for (int i = 0; i < 26; i++) {
                if (arr[i] >= 5) {
                    sb.append((char) (i+97));
                }
            }
        } else {
            sb.append("PREDAJA");
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
