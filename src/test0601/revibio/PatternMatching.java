package test0601.revibio;
/**
 * 2번 문제
 * numbers와 pattern 을 입력 받을 때 가능한 경우의 수
 * */
public class PatternMatching {

    public int solution(int[] numbers, int[] pattern) {
        int count = 0;
        int patternLength = pattern.length + 1; // pattern이 n개면 필요한 숫자는 n+1개

        // numbers 배열에서 가능한 모든 시작점 확인
        for (int i = 0; i <= numbers.length - patternLength; i++) {
            if (isPatternMatch(numbers, i, pattern)) {
                count++;
            }
        }

        return count;
    }

    private boolean isPatternMatch(int[] numbers, int startIndex, int[] pattern) {
        for (int i = 0; i < pattern.length; i++) {
            int current = numbers[startIndex + i];
            int next = numbers[startIndex + i + 1];

            if (pattern[i] == 1) { // 증가해야 함
                if (current >= next) {
                    return false;
                }
            } else if (pattern[i] == 0) { // 동일해야 함
                if (current != next) {
                    return false;
                }
            } else if (pattern[i] == -1) { // 감소해야 함
                if (current <= next) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PatternMatching pm = new PatternMatching();

        // 테스트 케이스 1
        int[] numbers1 = {4, 1, 3, 4, 4, 5, 5, 1};
        int[] pattern1 = {1, 0, -1};
        int result1 = pm.solution(numbers1, pattern1);

        System.out.println("입력:");
        System.out.print("numbers = [");
        for (int i = 0; i < numbers1.length; i++) {
            System.out.print(numbers1[i]);
            if (i < numbers1.length - 1) System.out.print(", ");
        }
        System.out.println("]");

        System.out.print("pattern = [");
        for (int i = 0; i < pattern1.length; i++) {
            System.out.print(pattern1[i]);
            if (i < pattern1.length - 1) System.out.print(", ");
        }
        System.out.println("]");
        System.out.println("출력: " + result1);

        // 상세 확인을 위한 디버깅
        System.out.println("\n패턴 매칭 상세 확인:");
        for (int i = 0; i <= numbers1.length - (pattern1.length + 1); i++) {
            System.out.print("인덱스 " + i + "부터: [");
            for (int j = 0; j < pattern1.length + 1; j++) {
                System.out.print(numbers1[i + j]);
                if (j < pattern1.length) System.out.print(", ");
            }
            System.out.print("] -> ");
            System.out.println(pm.isPatternMatch(numbers1, i, pattern1) ? "매칭됨" : "매칭안됨");
        }

        // 추가 테스트 케이스
        System.out.println("\n=== 추가 테스트 ===");
        int[] numbers2 = {1, 2, 2, 3, 4, 4, 3};
        int[] pattern2 = {1, 0, 1};
        int result2 = pm.solution(numbers2, pattern2);

        System.out.print("numbers = [");
        for (int i = 0; i < numbers2.length; i++) {
            System.out.print(numbers2[i]);
            if (i < numbers2.length - 1) System.out.print(", ");
        }
        System.out.println("]");

        System.out.print("pattern = [");
        for (int i = 0; i < pattern2.length; i++) {
            System.out.print(pattern2[i]);
            if (i < pattern2.length - 1) System.out.print(", ");
        }
        System.out.println("]");
        System.out.println("출력: " + result2);
    }
}
