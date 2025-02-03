package kundol.week2;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 2-I : 수학숙제 - 백준 2870
 * https://www.acmicpc.net/problem/2870
 * 문자열, 정렬, 파싱
 * */
public class MathHomework2870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        List<BigInteger> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            StringBuilder sb = new StringBuilder();
            boolean isSeq = false; // 연속된 숫자가 진행중인지 여부

            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);

                if (Character.isDigit(c)) {
                    sb.append(c);
                    isSeq = true;
                } else if (Character.isLetter(c)) {
                    isSeq = false;
                }

                if (!isSeq && !sb.toString().equals("")) {
                    list.add(new BigInteger(sb.toString()));
                    sb = new StringBuilder();
                }

                // 마지막 문자인 경우 체크
                if (j == input.length() - 1 && !sb.toString().equals("")) {
                    list.add(new BigInteger(sb.toString()));
                }
            }
        }
        Collections.sort(list);
        for (BigInteger i : list) {
            bw.write(i + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
