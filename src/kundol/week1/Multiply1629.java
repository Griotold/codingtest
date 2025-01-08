package kundol.week1;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 1-N: 곱셈 - 백준 1629
 * https://www.acmicpc.net/problem/1629
 * 수학, 분할정복
 * */
public class Multiply1629 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        System.out.println(modularExponentiation(A, B, C));
    }

    // Function to compute (A^B) % C using divide and conquer
    public static long modularExponentiation(long base, long exp, long mod) {
        if (exp == 0) return 1; // Base case: A^0 = 1
        if (exp == 1) return base % mod; // Base case: A^1 % C

        long half = modularExponentiation(base, exp / 2, mod);
        half = (half * half) % mod; // Combine results for even exponent

        if (exp % 2 != 0) { // If exponent is odd, multiply by base once more
            half = (half * base) % mod;
        }

        return half;
    }
}
