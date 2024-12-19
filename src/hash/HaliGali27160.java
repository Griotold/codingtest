package hash;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 비기너 241102 토 - 할리갈리 - 백준 27160
 * https://www.acmicpc.net/problem/27160
 * 해시
 * */
public class HaliGali27160 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Map<String, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String fruit = st.nextToken();
            int count = Integer.parseInt(st.nextToken());
            map.put(fruit, map.getOrDefault(fruit, 0) + count);
        }
        boolean hasExactlyFive = map.values().stream().anyMatch(value -> value == 5);
        String answer = hasExactlyFive ? "YES\n" : "NO\n";

        bw.write(answer);

        bw.flush();
        bw.close();
        br.close();
    }
}
