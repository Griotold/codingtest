package test0601.stackAndQueue;

import java.util.*;

public class SavingPrincess {
    // 8 3
    // 7
    static int solution(int n, int target) {
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        int count = 1;
        while (queue.size() > 1) {
            if (count == target) {
                queue.poll();
                count = 1; // ★ 이 부분이 중요!
            } else {
                queue.add(queue.removeFirst());
                count++;
            }
        }
        return queue.removeFirst();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = sc.nextInt();
        System.out.println(solution(n, num));
    }
}
