package kundol.week1;

import java.io.*;

/**
 * 1-F: ROT13 - 백준 11655
 * https://www.acmicpc.net/problem/11655
 * 문자열, 구현
 * */
public class ROT13_11655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if ('A' <= c && c <= 'Z') { // 대문자 범위
                sb.append((char) ((c - 'A' + 13) % 26 + 'A'));
            } else if ('a' <= c && c <= 'z') { // 소문자 범위
                sb.append((char) ((c - 'a' + 13) % 26 + 'a'));
            } else { // 알파벳이 아닌 경우 (공백, 숫자, 특수문자 등)
                sb.append(c);
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
