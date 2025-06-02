package test0601.connectwave;

import java.util.*;

/**
 * 두 번째 문제
 * 1. 중복 제거 - Set 활용
 * 2. 가능한 순열 생성 - 완전탐색, 백트래킹, 재귀
 * 3. 조건 검사
 * 백준 10974 : 모든 순열
 * https://www.acmicpc.net/problem/10974
 * 프로그래머스 - 모의고사, 소수찾기
 * https://school.programmers.co.kr/learn/courses/30/lessons/42840
 * https://school.programmers.co.kr/learn/courses/30/lessons/42839
 * */
public class UpDownSort {

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

    private void permute(List<Integer> arr, int start, List<List<Integer>> perms) {
        if (start == arr.size() - 1) {
            perms.add(new ArrayList<>(arr));
            return;
        }
        for (int i = start; i < arr.size(); i++) {
            Collections.swap(arr, start, i);
            permute(arr, start + 1, perms);
            Collections.swap(arr, start, i);
        }
    }

    public int[] solution(int[] arr) {
        // 중복 제거
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : arr) set.add(num);
        List<Integer> unique = new ArrayList<>(set);
        List<Integer> result = null;

        // 순열 생성
        List<List<Integer>> perms = new ArrayList<>();
        permute(unique, 0, perms);

        // 조건 만족하는 순열 찾기
        for (List<Integer> perm : perms) {
            if (checkCondition(perm)) {
                result = perm;
                break;
            }
        }
        return result != null ? result.stream().mapToInt(i -> i).toArray() : new int[0];
    }

    public static void main(String[] args) {
        UpDownSort sorter = new UpDownSort();
        int[] arr = {3, -2, 8, 5, 3, 9};
        int[] result = sorter.solution(arr);
        System.out.println(Arrays.toString(result)); // [5, 8, 3, 9, -2]와 같은 결과가 나올 수 있음
    }
}
