package kundol.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1-K: 팰린드롬 만들기 - 백준 1213
 * https://www.acmicpc.net/problem/1213
 * 다른 사람의 풀이 : https://kimtaesoo99.tistory.com/49
 *
 * */
public class MakingPalindrome1213_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int[] alphabets = new int[26];

        // 각 알파벳의 빈도를 계산
        for (char ch : str.toCharArray()) {
            alphabets[ch - 'A']++;
        }

        // 홀수 빈도 문자가 몇 개인지 확인
        int oddCount = 0;
        int oddIndex = -1; // 홀수 빈도의 문자의 인덱스를 저장
        for (int i = 0; i < alphabets.length; i++) {
            if (alphabets[i] % 2 != 0) {
                oddCount++;
                oddIndex = i;
            }
            if (oddCount >= 2) { // 홀수 문자가 두 개 이상이면 불가능
                System.out.println("I'm Sorry Hansoo");
                return;
            }
        }

        // 팰린드롬의 절반 생성
        for (int i = 0; i < alphabets.length; i++) {
            for (int j = 0; j < alphabets[i] / 2; j++) {
                sb.append((char) (i + 'A'));
            }
        }

        // 홀수 빈도 문자가 있으면 가운데에 추가
        String halfPalindrome = sb.toString();
        if (oddCount == 1) {
            sb.append((char) (oddIndex + 'A'));
        }

        // 팰린드롬 완성: 절반 + 가운데 문자 + 절반의 역순
        sb.append(new StringBuilder(halfPalindrome).reverse());

        System.out.println(sb.toString());
    }
}
