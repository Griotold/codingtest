package test0601.sorting;

import java.util.*;

public class InsertSort {

    // 4
    // 5 2 9 1
    // 1 2 5 9
    static int[] solution(int n, int[] arr) {
        for(int i = 1; i < n; i++) {
            int tmp = arr[i];
            int j;
            for(j = i - 1; j>= 0; j--) {
                if(arr[j] > tmp) arr[j+1] = arr[j];
                else break;
            }
            arr[j+1] = tmp;
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int[] result = solution(n, arr);
        String resultString = Arrays.toString(result);
        System.out.println(resultString);
    }
}
