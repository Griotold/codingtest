package kundol.week1;

import java.io.*;

/**
 * 1-B : 알파벳 개수 - 백준 10808
 * https://www.acmicpc.net/problem/10808
 * 구현
 * */
public class NumberOfAlphabet10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] alphabets = new int[26];
        String str = br.readLine();

        for (char ch : str.toCharArray()) {
            int index = ch - 'a';
            alphabets[index]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int alphabet : alphabets) {
            sb.append(alphabet).append(" ");
        }
        sb.append("\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}
