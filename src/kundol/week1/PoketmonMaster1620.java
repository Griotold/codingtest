package kundol.week1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 1-I: 나는야 포켓몬 마스터 이다솜 - 백준 1620
 * https://www.acmicpc.net/problem/1620
 * 해시
 * */
public class PoketmonMaster1620 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 도감에 수록된 포켓몬 개수
        int M = Integer.parseInt(st.nextToken()); // 맞춰야 하는 문제 개수

        // 두 개의 맵을 사용: 이름 -> 번호, 번호 -> 이름
        Map<String, Integer> nameToNumber = new HashMap<>();
        Map<Integer, String> numberToName = new HashMap<>();

        // 도감 데이터 입력
        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            nameToNumber.put(name, i);
            numberToName.put(i, name);
        }

        StringBuilder sb = new StringBuilder();

        // 문제 데이터 처리
        for (int i = 0; i < M; i++) {
            String question = br.readLine();
            if (Character.isDigit(question.charAt(0))) { // 숫자인 경우 (번호로 이름 찾기)
                int number = Integer.parseInt(question);
                sb.append(numberToName.get(number)).append("\n");
            } else { // 문자인 경우 (이름으로 번호 찾기)
                sb.append(nameToNumber.get(question)).append("\n");
            }
        }

        // 결과 출력
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
