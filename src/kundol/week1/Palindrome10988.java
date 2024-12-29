package kundol.week1;

import java.io.*;

/**
 * 1-D: 팰린드롬인지 확인하기 - 백준 10988
 * https://www.acmicpc.net/problem/10988
 * 문자열, 구현
 * */
public class Palindrome10988 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder(str);
        String reversed = sb.reverse().toString();
        if (str.equals(reversed)) {
            bw.write("1\n");
        } else {
            bw.write("0\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
