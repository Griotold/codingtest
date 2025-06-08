package test0601.revibio;

import java.util.*;

/**
 * 4. 끝부분 매칭
 * */
public class SuffixMatching {

    public int solution(String[] words) {
        Set<String> processedSuffixes = new HashSet<>();
        Map<String, Integer> wordCount = new HashMap<>();
        int count = 0;

        // 각 단어의 개수 세기
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // 각 단어를 suffix로 사용 (중복 제거)
        for (String suffix : words) {
            if (processedSuffixes.contains(suffix)) {
                continue; // 이미 처리한 suffix는 건너뛰기
            }

            // 현재 suffix로 끝나는 서로 다른 단어들 찾기
            Set<String> matchingWords = new HashSet<>();
            for (String word : words) {
                if (word.endsWith(suffix)) {
                    matchingWords.add(word);
                }
            }

            // suffix 자체도 포함되므로 제외하고 카운트
            matchingWords.remove(suffix);
            count += matchingWords.size();

            // 같은 단어가 2개 이상 있으면 추가 카운트
            if (wordCount.get(suffix) >= 2) {
                count += wordCount.get(suffix) - 1; // 자기 자신 제외하고 나머지
            }

            processedSuffixes.add(suffix);
        }

        return count;
    }

    public static void main(String[] args) {
        SuffixMatching sm = new SuffixMatching();

        // 테스트 케이스 1
        String[] test1 = {"back", "backdoor", "gammon", "blackgammon", "comeback", "come", "door"};
        int result1 = sm.solution(test1);

        System.out.println("테스트 1:");
        System.out.print("입력: [");
        for (int i = 0; i < test1.length; i++) {
            System.out.print("\"" + test1[i] + "\"");
            if (i < test1.length - 1) System.out.print(", ");
        }
        System.out.println("]");

        // 상세 분석
        System.out.println("매칭 분석:");
        Set<String> analyzed = new HashSet<>();
        for (String suffix : test1) {
            if (analyzed.contains(suffix)) continue;

            List<String> matches = new ArrayList<>();
            for (String word : test1) {
                if (word.endsWith(suffix)) {
                    matches.add(word);
                }
            }

            if (matches.size() >= 2) {
                System.out.printf("suffix \"%s\": %s (%d개) ✓\n", suffix, matches, matches.size());
                analyzed.add(suffix);
            }
        }
        System.out.println("결과: " + result1);

        System.out.println("\n" + "=".repeat(50));

        // 테스트 케이스 2
        String[] test2 = {"cba", "a", "a", "b", "ba", "ca"};
        int result2 = sm.solution(test2);

        System.out.println("테스트 2:");
        System.out.print("입력: [");
        for (int i = 0; i < test2.length; i++) {
            System.out.print("\"" + test2[i] + "\"");
            if (i < test2.length - 1) System.out.print(", ");
        }
        System.out.println("]");

        // 상세 분석
        System.out.println("매칭 분석:");
        Set<String> analyzed2 = new HashSet<>();
        for (String suffix : test2) {
            if (analyzed2.contains(suffix)) continue;

            List<String> matches = new ArrayList<>();
            for (String word : test2) {
                if (word.endsWith(suffix)) {
                    matches.add(word);
                }
            }

            if (matches.size() >= 2) {
                System.out.printf("suffix \"%s\": %s (%d개) ✓\n", suffix, matches, matches.size());
                analyzed2.add(suffix);
            }
        }
        System.out.println("결과: " + result2);
    }
}
