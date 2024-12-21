package hash;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 241105 화 비기너 - 민균이의 비밀번호 - 백준 9933
 * https://www.acmicpc.net/problem/9933
 * 해시
 * */
public class Password9933 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        String password = null;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (isPalindrome(str)) {
                password = str;
                break;
            }
            map.put(str, map.getOrDefault(str, 0) + 1);
            String reversed = new StringBuilder(str).reverse().toString();
            map.put(reversed, map.getOrDefault(reversed, 0) + 1);

            if (map.get(str) == 2) {
                password = str;
                break;
            }
        }

        if (password != null) {
            int length = password.length();
            char middleChar = password.charAt(length / 2);
            bw.write(length + " " + middleChar);
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean isPalindrome(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    /**
     * 다른 풀이 - Set을 이용한 풀이
     * https://propercoding.tistory.com/308
     */
    public static void anotherSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 단어의 수를 입력 받음

        Set<String> set = new HashSet<>(); // 중복을 제거하기 위해 Set을 사용

        for (int i = 0; i < n; i++) {
            String s = br.readLine(); // 단어를 입력 받음

            set.add(s); // 입력 받은 단어를 Set에 추가

            StringBuilder sb = new StringBuilder(s);
            String reverse = sb.reverse().toString(); // 입력 받은 단어를 뒤집어서 새로운 문자열 만듬

            if (set.contains(reverse)) { // 뒤집은 문자열이 Set에 있는지 확인하여 비밀번호인지 검사
                System.out.println(reverse.length() + " " + reverse.charAt(reverse.length() / 2));
                // 비밀번호의 길이와 가운데 글자를 출력
                break; // 비밀번호를 찾았으므로 반복문을 종료
            }
        }
    }

}
