package hash;

import java.io.*;
import java.util.*;

/**
 * 241107 목 - 회사에 있는 사람 - 백준 7785
 * https://www.acmicpc.net/problem/7785
 * 해시
 * 사전 역순 출력을 위해 TreeMap 사용
 * */
public class PeopleInCompany7785 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        // 사전 역순 출력을 위해 TreeMap
        Map<String, Integer> map = new TreeMap<>(Collections.reverseOrder());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String person = st.nextToken();
            String access = st.nextToken();
            if ("enter".equals(access)) {
                map.put(person, map.getOrDefault(person, 0) + 1);
            } else {
                map.remove(person);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            sb.append(entry.getKey()).append("\n");
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
