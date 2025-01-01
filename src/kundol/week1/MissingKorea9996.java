package kundol.week1;

import java.io.*;

/**
 * 1-G: 한국이 그리울 땐 서버에 접속하지 - 백준 9996
 * https://www.acmicpc.net/problem/9996
 * 정규표현식
 * */
public class MissingKorea9996 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String pattern = br.readLine();

        // Split pattern into prefix and suffix around '*'
        // *, \ -> 둘 다 와일드 카드이기 때문에 이중으로 escape 해야 한다.
        String[] parts = pattern.split("\\*", 2);
        String prefix = parts[0];
        String suffix = parts[1];

        while (N-- > 0) {
            String name = br.readLine();
            // Check if name matches the pattern
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
