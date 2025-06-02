package test0601.connectwave;
/**
 * 네 번째 문제
 * 백준 4862 - 마지막 자리 https://www.acmicpc.net/problem/4862
 * 백준 1009 - 분산처리 https://www.acmicpc.net/problem/1009
 * */
public class PowerLastFiveDigits {
    public int solution(long n, long m) {
        long mod = 100_000;
        long result = 1;
        for (long i = 0; i < m; i++) {
            result = (result * n) % mod;
        }
        return (int) result;
    }

    // 테스트 코드
    public static void main(String[] args) {
        PowerLastFiveDigits solver = new PowerLastFiveDigits();
        System.out.println(solver.solution(2, 26)); // 출력: 8864 (예시 오류 주의)
        System.out.println(solver.solution(3, 5));   // 3^5=243 → 00243 → 243
    }
}
