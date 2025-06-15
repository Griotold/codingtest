package programmers.level1;

import java.util.Arrays;

/**
 * 비밀지도 (카카오 블라인드 채용)
 * https://school.programmers.co.kr/learn/courses/30/lessons/17681
 * 비트 연산과 if-else 방식 두 가지 풀이
 */
public class SecretMap {

    /**
     * 풀이 1: 비트 연산 사용
     * OR 연산으로 두 지도를 합치고, AND 연산으로 각 비트 확인
     */
    public String[] solution1(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];

        for(int i = 0; i < n; i++) {
            // OR 연산으로 두 지도 합치기
            int combined = arr1[i] | arr2[i];

            // 이진수 문자열로 변환 (직접 구현)
            StringBuilder sb = new StringBuilder();
            for(int j = n-1; j >= 0; j--) {
                if((combined & (1 << j)) != 0) {
                    sb.append('#');
                } else {
                    sb.append(' ');
                }
            }
            result[i] = sb.toString();
        }

        return result;
    }

    /**
     * 풀이 2: if-else 사용
     * 이진수 문자열로 변환 후 각 자리를 문자로 비교
     */
    public String[] solution2(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];

        for(int i = 0; i < n; i++) {
            // 각각을 이진수 문자열로 변환
            String binary1 = Integer.toBinaryString(arr1[i]);
            String binary2 = Integer.toBinaryString(arr2[i]);

            // n자리로 패딩
            while(binary1.length() < n) binary1 = "0" + binary1;
            while(binary2.length() < n) binary2 = "0" + binary2;

            StringBuilder sb = new StringBuilder();
            // 각 자리수를 하나씩 비교
            for(int j = 0; j < n; j++) {
                char c1 = binary1.charAt(j);
                char c2 = binary2.charAt(j);

                if(c1 == '1' || c2 == '1') {  // 하나라도 1이면
                    sb.append('#');
                } else {  // 둘 다 0이면
                    sb.append(' ');
                }
            }
            result[i] = sb.toString();
        }

        return result;
    }

    public static void main(String[] args) {
        SecretMap secretMap = new SecretMap();

        // 테스트 케이스
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        String[] expected = {"#####","# # #", "### #", "#  ##", "#####"};

        System.out.println("=== 비밀지도 테스트 ===");
        System.out.println("n: " + n);
        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("arr2: " + Arrays.toString(arr2));
        System.out.println();

        // solution1 테스트 (비트 연산)
        String[] result1 = secretMap.solution1(n, arr1, arr2);
        System.out.println("solution1 (비트 연산):");
        for(String line : result1) {
            System.out.println("\"" + line + "\"");
        }
        System.out.println("통과: " + Arrays.equals(result1, expected));
        System.out.println();

        // solution2 테스트 (if-else)
        String[] result2 = secretMap.solution2(n, arr1, arr2);
        System.out.println("solution2 (if-else):");
        for(String line : result2) {
            System.out.println("\"" + line + "\"");
        }
        System.out.println("통과: " + Arrays.equals(result2, expected));
        System.out.println();

        System.out.println("예상 결과:");
        for(String line : expected) {
            System.out.println("\"" + line + "\"");
        }
    }
}