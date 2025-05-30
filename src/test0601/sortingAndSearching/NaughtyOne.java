package test0601.sortingAndSearching;

import java.util.*;

public class NaughtyOne {
    // 9
    //120 125 152 130 135 135 143 127 160
    // 3 8
    static List<Integer> solution(int n, int[] arr) {
        List<Integer> result = new ArrayList<>();
        // 1. 정렬한다
        // 원본 배열을 복사해서 정렬
        int[] sorted = Arrays.copyOf(arr, n);
        Arrays.sort(sorted);
        // 2. 원래 배열과 비교해서 인덱스를 기록한다.
        for(int i = 0 ; i < n; i++) {
            if(result.size() == 2) break;
            if(arr[i] != sorted[i]) {
                result.add(i + 1);
            }
        }
        // 3. +1 해서 리턴한다.
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(n, arr));
    }
}
