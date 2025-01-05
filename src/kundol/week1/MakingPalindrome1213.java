package kundol.week1;

import java.io.*;

/**
 * 1-K: 팰린드롬 만들기 - 백준 1213
 * https://www.acmicpc.net/problem/1213
 * 구현, 그리디, 문자열
 * */
public class MakingPalindrome1213 {
    // 안 되는 경우는 빠르게 I'm Sorry Hansoo
    // 안 되는 경우는 홀수 개의 알파벳이 두 개 이상인 경우
    // 그게 아니면 모두 가능하다.
    // 일단 알파벳을 배열에 담아 놓고
    // 1. 홀수인 알파벳이 있는 경우
    // 2. 모두 짝수인 알파벳의 경우
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String name = br.readLine();
        int[] alphabets = new int[26];
        for (char ch : name.toCharArray()) {
            alphabets[ch - 'A']++;
        }
        int count = 0;
        for (int alphabetCount : alphabets) {
            if (alphabetCount % 2 == 1) count++;
        }
        StringBuilder sb = new StringBuilder();
        String answer = "";
        if (count >= 2) sb.append("I'm Sorry Hansoo").append("\n");
        else {
            if (count == 1) {
                for (int i = 0; i < alphabets.length; i++) {
                    if (alphabets[i] % 2 == 1) {
                        answer += (char) (i + 'A') ;
                        alphabets[i]--;
                        break;
                    }
                }
            }
            for (int i = alphabets.length - 1; i >= 0; i--) {
                while(alphabets[i] > 0) {
                    answer = (char)(i + 'A') + answer + (char)(i + 'A');
                    alphabets[i] -= 2;
                }
            }
            sb.append(answer).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
