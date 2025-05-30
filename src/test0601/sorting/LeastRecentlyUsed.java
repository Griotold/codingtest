package test0601.sorting;

import java.util.*;

public class LeastRecentlyUsed {

    // 5 9
    //1 2 3 2 6 2 3 5 7
    // 7 5 3 2 6
    static int[] solution(int n, int m, int[] arr) {
        int[] result = new int[n];
        for(int i = 0; i < m; i++) {
            int cur = arr[i];
            int pos = -1;
            // 캐시에 있는지 확인
            for(int j = 0; j < n; j++) {
                if(result[j] == cur) pos = j;
            }
            // 캐시에 있으면
            if(pos != -1) {
                for(int j = pos; j >= 1; j--) {
                    result[j] = result[j-1];
                }
                result[0] = cur;
            } else {
                // 캐시에 없으면
                for(int j = n-1; j >= 1; j--) {
                    result[j] = result[j-1];
                }
                result[0] = cur;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[m];
        for(int i = 0; i < m; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(solution(n, m, arr)));
    }
}
