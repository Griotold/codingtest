package test0601.sortingAndSearching;
import java.util.*;

public class MusicVideo {
    // 9 3
    //1 2 3 4 5 6 7 8 9
    // 17

    static int solution(int n, int m, int[] arr) {
        int lt = arr[arr.length - 1];
        int rt = Arrays.stream(arr).sum();
        int answer = 0;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            int count = 1, sum = 0;
            for (int x : arr) {
                if (sum + x > mid) {
                    count++;
                    sum = x;
                } else {
                    sum += x;
                }
            }
            if (count <= m) {
                answer = mid; // 정답 후보 저장
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        return answer;
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
