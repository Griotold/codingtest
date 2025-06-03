package test0601.connectwave;

public class PowerLastFiveDigits2 {

    int solution(long n, long m) {
        long mod = 100_000;
        long result = 1;
        for (long i = 0; i < m; i++) {
            result = (result * n) % mod;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        PowerLastFiveDigits solver = new PowerLastFiveDigits();
        System.out.println(solver.solution(2, 26)); // 출력: 8864 (예시 오류 주의)
        System.out.println(solver.solution(3, 5));   // 3^5=243 → 00243 → 243
    }
}
