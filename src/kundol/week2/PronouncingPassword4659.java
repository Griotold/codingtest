package kundol.week2;

import java.io.*;

/**
 * 2-H: 비밀번호 발음하기 - 백준 4659
 * https://www.acmicpc.net/problem/4659
 * 문자열, 구현
 * */
public class PronouncingPassword4659 {
    static int lcnt, vcnt;

    static boolean isVowel(int idx) {
        return idx == 'a' || idx == 'e' || idx == 'i' || idx == 'o' || idx == 'u';
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        while(true) {
            String str = br.readLine();
            if ("end".equals(str)) break;
            boolean isInvalid = false;
            boolean isIncludeVowel = false;
            lcnt = 0;
            vcnt = 0;
            int prev = -1;
            for (int i = 0; i < str.length(); i++) {
                int idx = str.charAt(i);
                if (isVowel(idx)) {
                    lcnt = 0;
                    vcnt++;
                    isIncludeVowel = true;
                } else {
                    vcnt = 0;
                    lcnt++;
                }
                if (vcnt == 3 || lcnt == 3) isInvalid = true;
                if (i >= 1 && prev == idx && (idx != 'e' && idx != 'o')) {
                    isInvalid = true;
                }
                prev = idx;
            }
            if (isIncludeVowel == false) isInvalid = true;
            if (isInvalid) {
                sb.append("<").append(str).append(">").append(" is not acceptable. ").append("\n");
            } else {
                sb.append("<").append(str).append(">").append(" is acceptable. ").append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
