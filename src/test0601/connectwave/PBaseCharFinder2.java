package test0601.connectwave;

public class PBaseCharFinder2 {

    String toBase(int n, int p) {
        if(n < p) {
            return String.valueOf(n);
        }
        return toBase(n / p, p) + (n % p);
    }

    int solution(int p, int index) {
        StringBuilder sb = new StringBuilder();
        int n = 0;
        while(sb.length() < index) {
            sb.append(toBase(n, p));
            n++;
        }
        return Character.getNumericValue(sb.charAt(index - 1));
    }

    public static void main(String[] args) {
        PBaseCharFinder2 finder = new PBaseCharFinder2();
        System.out.println(finder.solution(10, 15)); // 결과 확인
    }
}
