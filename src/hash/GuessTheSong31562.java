package hash;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 241103 일 비기너 - 전주 듣고 노래 맞히기 - 백준 31562
 * https://www.acmicpc.net/problem/31562
 * 해시
 * */
public class GuessTheSong31562 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int titleSize = Integer.parseInt(st.nextToken());
            String title = st.nextToken();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 3; j++) {
                sb.append(st.nextToken());
            }
            map.put(title, sb.toString());
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 3; j++) {
                sb.append(st.nextToken());
            }
            String input = sb.toString();
            long count = map.values().stream().filter(value -> value.equals(input)).count();
            if (count == 0) {
                answer.append("!\n");
            } else if (count == 1) {
                String title = map.entrySet().stream()
                        .filter(entry -> entry.getValue().equals(input))
                        .map(Map.Entry::getKey)
                        .findFirst()
                        .orElse("");
                answer.append(title).append("\n");
            } else {
                answer.append("?\n");
            }

        }

        bw.write(answer.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 다른 풀이 - https://graycode.tistory.com/729
     * map에 저장할 때 중복 처리를 같이 하고 있어서 매우 효율적이다.
     * */
    public static void anotherSolve(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();
        while (n-- > 0) {
            String[] arr = br.readLine().split(" ", 3);
            String key = arr[2].substring(0, 5);

            map.put(key, map.containsKey(key) ? "?\n" : arr[1] + "\n");
        }

        while (m-- > 0) sb.append(map.getOrDefault(br.readLine(), "!\n"));

        bw.write(sb.toString());
        bw.flush();
    }
}
