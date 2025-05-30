package test0601.sortingAndSearching;
import java.util.*;
public class StableAllocator {

    // 5 3
    //1 2 8 4 9
    // 3
    static int count(int[] arr, int dist) {
        int cnt = 1;
        int ep = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] - ep >= dist) {
                cnt++;
                ep=arr[i];
            }
        }
        return cnt;
    }

    static int solution(int n, int m, int[] arr) {
        Arrays.sort(arr);
        int lt = 1;
        int rt = arr[arr.length - 1] - arr[0];
        int result = 0;
        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if(count(arr, mid) >= m) {
                result = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(n, m, arr));
    }
}
