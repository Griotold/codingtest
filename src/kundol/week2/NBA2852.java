package kundol.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2-L : NBA 농구 - 백준 2852
 * https://www.acmicpc.net/problem/2852
 * 구현, 문자열
 * */
public class NBA2852 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int score1 = 0;
        int score2 = 0;
        int team1Time = 0;
        int team2Time = 0;
        int prevTime = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int team = Integer.parseInt(st.nextToken());
            String[] time = st.nextToken().split(":");
            int currentTime = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);

            // 이전 시간부터 현재 시간까지 이기고 있던 팀의 시간 추가
            if (score1 > score2) {
                team1Time += currentTime - prevTime;
            } else if (score2 > score1) {
                team2Time += currentTime - prevTime;
            }

            // 점수 업데이트
            if (team == 1) score1++;
            else score2++;

            prevTime = currentTime;
        }

        // 마지막 득점부터 경기 종료(48분)까지 계산
        if (score1 > score2) {
            team1Time += 48 * 60 - prevTime;
        } else if (score2 > score1) {
            team2Time += 48 * 60 - prevTime;
        }

        // 결과 출력
        System.out.printf("%02d:%02d\n", team1Time/60, team1Time%60);
        System.out.printf("%02d:%02d\n", team2Time/60, team2Time%60);

        br.close();
    }
}
