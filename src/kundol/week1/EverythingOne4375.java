package kundol.week1;

import java.io.*;
import java.util.Scanner;

/**
 * 1-O: 1 - 백준 4375
 * https://www.acmicpc.net/problem/4375
 * 수학, 브루트포스
 * */
public class EverythingOne4375 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String line;
        Scanner sc = new Scanner(System.in);

        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line.trim());
            long count = 1;
            int result = 1;

            while (count % n != 0) {
                count = (count * 10 + 1) % n;
                result++;
            }

            sb.append(result).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}
