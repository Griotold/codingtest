package test0601.revibio;
/**
 * 1번 문제
 * 각 단어의 첫 글자와 다음 단어의 마지막 글자 합치기
 * */
public class WordCombination {

    public String[] solution(String[] words) {
        String[] result = new String[words.length];

        for (int i = 0; i < words.length; i++) {
            char firstChar = words[i].charAt(0);
            char lastChar;

            // 마지막 요소인 경우 첫 번째 요소의 마지막 글자와 합침
            if (i == words.length - 1) {
                lastChar = words[0].charAt(words[0].length() - 1);
            } else {
                // 다음 요소의 마지막 글자와 합침
                lastChar = words[i + 1].charAt(words[i + 1].length() - 1);
            }

            result[i] = "" + firstChar + lastChar;
        }

        return result;
    }

    public static void main(String[] args) {
        WordCombination wc = new WordCombination();

        // 테스트 케이스 1
        String[] test1 = {"cat", "dog", "ferret", "scorpion"};
        String[] result1 = wc.solution(test1);

        System.out.println("입력: [cat, dog, ferret, scorpion]");
        System.out.print("출력: [");
        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i]);
            if (i < result1.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        // 테스트 케이스 2 - 추가 테스트
        String[] test2 = {"apple", "banana", "cherry", "date", "elderberry"};
        String[] result2 = wc.solution(test2);

        System.out.println("\n입력: [apple, banana, cherry, date, elderberry]");
        System.out.print("출력: [");
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i]);
            if (i < result2.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
