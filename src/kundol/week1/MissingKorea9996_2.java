package kundol.week1;

import java.io.*;

/**
 * 1-G: 한국이 그리울 땐 서버에 접속하지 - 백준 9996
 * https://www.acmicpc.net/problem/9996
 * 정규표현식 X
 */
public class MissingKorea9996_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String pattern = br.readLine();

        // '*'를 기준으로 패턴을 분리
        int starIndex = pattern.indexOf('*');
        String prefix = pattern.substring(0, starIndex); // '*' 앞부분
        String suffix = pattern.substring(starIndex + 1); // '*' 뒷부분

        while (N-- > 0) {
            String name = br.readLine();

            // 조건 확인
            if (name.length() >= prefix.length() + suffix.length() &&
                    name.startsWith(prefix) &&
                    name.endsWith(suffix)) {
                sb.append("DA").append("\n");
            } else {
                sb.append("NE").append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
