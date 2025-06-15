package programmers.level1;

import java.util.Arrays;

/**
 * K번째 수
 * https://school.programmers.co.kr/learn/courses/30/lessons/42748
 * Arrays.copyOfRange()를 사용한 깔끔한 풀이
 */
public class KthNumber {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i = 0; i < commands.length; i++) {
            int start = commands[i][0] - 1;  // 1-based to 0-based
            int end = commands[i][1];        // copyOfRange는 end 미포함이므로 -1 하지 않음
            int index = commands[i][2] - 1;  // 1-based to 0-based

            // copyOfRange로 부분 배열 생성 (크기 자동 계산)
            int[] subArray = Arrays.copyOfRange(array, start, end);
            Arrays.sort(subArray);
            answer[i] = subArray[index];
        }

        return answer;
    }

    public static void main(String[] args) {
        KthNumber solution = new KthNumber();

        // 테스트 케이스 1
        int[] array1 = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands1 = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] result1 = solution.solution(array1, commands1);
        System.out.println("테스트 케이스 1:");
        System.out.println("입력: " + Arrays.toString(array1));
        System.out.println("commands: " + Arrays.deepToString(commands1));
        System.out.println("결과: " + Arrays.toString(result1));
        System.out.println("예상: [5, 6, 3]");
        System.out.println("통과: " + Arrays.equals(result1, new int[]{5, 6, 3}));
        System.out.println();

        // 테스트 케이스 2 - 단일 요소
        int[] array2 = {1, 2, 3, 4, 5};
        int[][] commands2 = {{1, 1, 1}, {3, 3, 1}, {5, 5, 1}};
        int[] result2 = solution.solution(array2, commands2);
        System.out.println("테스트 케이스 2:");
        System.out.println("입력: " + Arrays.toString(array2));
        System.out.println("commands: " + Arrays.deepToString(commands2));
        System.out.println("결과: " + Arrays.toString(result2));
        System.out.println("예상: [1, 3, 5]");
        System.out.println("통과: " + Arrays.equals(result2, new int[]{1, 3, 5}));
        System.out.println();

        // 테스트 케이스 3 - 역순 정렬
        int[] array3 = {5, 4, 3, 2, 1};
        int[][] commands3 = {{1, 5, 1}, {1, 5, 5}, {2, 4, 2}};
        int[] result3 = solution.solution(array3, commands3);
        System.out.println("테스트 케이스 3:");
        System.out.println("입력: " + Arrays.toString(array3));
        System.out.println("commands: " + Arrays.deepToString(commands3));
        System.out.println("결과: " + Arrays.toString(result3));
        System.out.println("예상: [1, 5, 3]");
        System.out.println("통과: " + Arrays.equals(result3, new int[]{1, 5, 3}));
        System.out.println();

        // copyOfRange 사용법 예시
        System.out.println("=== copyOfRange 사용법 예시 ===");
        int[] original = {1, 2, 3, 4, 5, 6, 7};
        int[] sub1 = Arrays.copyOfRange(original, 1, 4); // index 1~3
        int[] sub2 = Arrays.copyOfRange(original, 0, 3); // index 0~2
        int[] sub3 = Arrays.copyOfRange(original, 3, 7); // index 3~6

        System.out.println("원본 배열: " + Arrays.toString(original));
        System.out.println("copyOfRange(original, 1, 4): " + Arrays.toString(sub1));
        System.out.println("copyOfRange(original, 0, 3): " + Arrays.toString(sub2));
        System.out.println("copyOfRange(original, 3, 7): " + Arrays.toString(sub3));
    }
}