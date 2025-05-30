package test0601.sortingAndSearching;

import java.util.*;

public class CheckDuplication {

    // 8
    //20 25 52 30 39 33 43 33
    // D
    /**
     * 1. 해쉬 활용
     * */
    static String solution(int n, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])) { return "D";}
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        return "U";
    }

    /**
     * 2. 정렬 후 인접비교
     * */
    static String solution2(int n, int[] arr) {
        Arrays.sort(arr);
        for(int i = 0 ; i < n-1; i++) {
            if(arr[i] == arr[i + 1]) return "D";
        }
        return "U";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(n, arr));
    }
}
