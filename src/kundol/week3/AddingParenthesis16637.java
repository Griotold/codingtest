package kundol.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 3-F: 괄호 추가하기 - 백준 16637
 * https://www.acmicpc.net/problem/16637
 *
 * */
public class AddingParenthesis16637 {
    static List<Integer> nums = new ArrayList<>();
    static List<Character> operators = new ArrayList<>();
    static int N, ret;
    static String str;

    static int oper(char a, int b, int c) {
        if (a == '+') return b + c;
        if (a == '-') return b - c;
        if (a == '*') return b * c;
        return 0;
    }

    static void go(int here, int num) {
        if (here == nums.size() - 1) {
            ret = Math.max(ret, num);
            return;
        }
        go(here + 1, oper(operators.get(here), num, nums.get(here + 1)));

        if(here + 2 <= nums.size() - 1){
            int temp = oper(operators.get(here + 1), nums.get(here + 1), nums.get(here + 2));
            go(here + 2, oper(operators.get(here), num, temp));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        str = br.readLine();
        ret= Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) nums.add(str.charAt(i) - '0');
            else operators.add(str.charAt(i));
        }
        go(0, nums.get(0));
        System.out.println(ret);

        br.close();
    }
}
