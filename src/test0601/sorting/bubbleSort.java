package test0601.sorting;

import java.util.*;

public class bubbleSort {

    // 4
    // 5 2 9 1
    // 1 2 5 9
    static int[] solution(int n, int[] arr) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n - i - 1; j++) { // n - i - 1로 범위를 줄임
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(solution(n, arr)));
    }
}
