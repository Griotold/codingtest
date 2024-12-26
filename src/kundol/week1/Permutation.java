package kundol.week1;

public class Permutation {

    static int[] arr;

    // 오름차순 순서 없이 n 개중에서 r 개를 뽑는 경우
    // 사용 예시: permutation(arr, 0, n, 4);
    static void permutation(int n, int r, int depth) {
        if (depth == r) {
            print(arr, r);
            return;
        }

        for (int i=depth; i<n; i++) {
            swap(arr, i, depth);
            permutation(n, r, depth + 1);
            swap(arr, i, depth);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 배열 출력
    static void print(int[] arr, int r) {
        for (int i = 0; i < r; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
