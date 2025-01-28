package kundol.week2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 2-F: 사과 담기 - 백준 2828
 *  https://www.acmicpc.net/problem/1992
 *  그리디
 * */
public class AddingApples2828 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int J = Integer.parseInt(br.readLine());
        int ret = 0;
        int left = 1;
        int right = left + M - 1;
        while (J-- > 0) {
            int temp = Integer.parseInt(br.readLine());
            if (left <= temp && temp <= right) {
                continue;
            }
            int addingValue = 0;
            if (temp > right) {
                addingValue = temp - right;
                left += addingValue;
                right += addingValue;
            }
            if (temp < left) {
                addingValue = left - temp;
                left -= addingValue;
                right -= addingValue;
            }
            ret += addingValue;
        }
        bw.write(ret + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
