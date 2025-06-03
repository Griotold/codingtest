package test0601.connectwave;

import java.util.*;

public class UpdownSort2 {

    // 조건 검사 메서드(원본과 동일)
    private boolean checkCondition(List<Integer> arr) {
        // 짝수 인덱스(0,2,4,...) 내림차순
        for (int i = 0; i + 2 < arr.size(); i += 2) {
            if (arr.get(i) <= arr.get(i + 2)) return false;
        }
        // 0,1,3,5,... 인덱스 오름차순
        List<Integer> oddIndices = new ArrayList<>();
        oddIndices.add(0);
        oddIndices.add(1);
        for (int i = 3; i < arr.size(); i += 2) {
            oddIndices.add(i);
        }
        for (int i = 0; i < oddIndices.size() - 1; i++) {
            int idx1 = oddIndices.get(i);
            int idx2 = oddIndices.get(i + 1);
            if (arr.get(idx1) >= arr.get(idx2)) return false;
        }
        return true;
    }

    private boolean dfs(List<Integer> unique, boolean[] used, List<Integer> perm, int depth, List<Integer> answer) {
        if (depth == unique.size()) {
            if (checkCondition(perm)) {
                answer.addAll(perm); // 결과 복사
                return true; // 조건 만족하면 바로 종료
            }
            return false;
        }
        for (int i = 0; i < unique.size(); i++) {
            if (!used[i]) {
                used[i] = true;
                perm.add(unique.get(i));
                if (dfs(unique, used, perm, depth + 1, answer)) return true; // 조건 만족 시 바로 리턴
                perm.remove(perm.size() - 1);
                used[i] = false;
            }
        }
        return false;
    }

    public int[] solution(int[] arr) {
        Set<Integer> set = new LinkedHashSet<Integer>();
        for (int num : arr) {
            set.add(num);
        }
        List<Integer> unique = new ArrayList<>(set);
        // 2. DFS 백트래킹으로 순열 생성 & 조건 만족하는 첫 결과 찾기
        boolean[] used = new boolean[unique.size()];
        List<Integer> perm = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();

        dfs(unique, used, perm, 0, answer);

        // 3. 결과 리턴
        return answer != null ? answer.stream().mapToInt(i -> i).toArray() : new int[0];
    }

    public static void main(String[] args) {
        UpDownSort sorter = new UpDownSort();
        int[] arr = {3, -2, 8, 5, 3, 9};
        int[] result = sorter.solution(arr);
        System.out.println(Arrays.toString(result)); // [5, 8, 3, 9, -2]와 같은 결과가 나올 수 있음
    }
}
