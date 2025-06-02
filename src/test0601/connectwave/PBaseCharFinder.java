package test0601.connectwave;
/**
 * 세 번째 문제
 * 백준 2745 - 진법 변환
 * https://www.acmicpc.net/problem/2745
 * 백준 11005 - 진법 변환 2
 * https://www.acmicpc.net/problem/11005
 * 프로그래머스 - N진수 게임
 * https://school.programmers.co.kr/learn/courses/30/lessons/17687
 * */
public class PBaseCharFinder {

    // 십진수 n을 p진법 문자열로 변환 (재귀적)
    private String toBase(int n, int p) {
        if (n < p) {
            return String.valueOf(n);
        }
        return toBase(n / p, p) + (n % p);
    }

    public int solution(int p, int index) {
        StringBuilder sb = new StringBuilder();
        int n = 0;
        while (sb.length() < index) {
            sb.append(toBase(n, p));
            n++;
        }
        return Character.getNumericValue(sb.charAt(index - 1));
    }

    // 테스트 코드
    public static void main(String[] args) {
        PBaseCharFinder finder = new PBaseCharFinder();
        System.out.println(finder.solution(10, 15)); // 결과 확인
    }
}
