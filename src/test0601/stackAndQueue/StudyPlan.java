package test0601.stackAndQueue;

import java.util.*;

public class StudyPlan {
    //CBA
    //CBDAGE
    // YES
    static String solution(String target, String plan) {
        Deque<Character> queue = new ArrayDeque<>();
        for(int i = 0 ; i < target.length(); i++) {
            queue.offer(target.charAt(i));
        }
        for(char x : plan.toCharArray()){
            if(queue.contains(x)){
                if(x!=queue.poll()) return "NO";
            }
        }
        if(!queue.isEmpty()) return "NO";
        return "YES";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String target = sc.nextLine();
        String plan = sc.nextLine();
        System.out.println(solution(target, plan));
    }
}
