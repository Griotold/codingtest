package test0601.sortingAndSearching;

import java.util.*;
public class binarySearch {
    // 8 32
    //23 87 65 12 57 32 99 81
    // 3
    static int solution(int n, int m, int[] arr) {
        Arrays.sort(arr);
        int lt = 0;
        int rt = arr.length - 1;
        int mid;
        while(lt < rt) {
            mid = (lt + rt) / 2;
            if(arr[mid] == m) return mid + 1;
            else if(arr[mid] > m) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(n, m, arr));
    }
}
