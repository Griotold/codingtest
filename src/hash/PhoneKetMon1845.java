package hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 241106 수 - 폰켓몬 - 프로그래머스 1845
 * https://school.programmers.co.kr/learn/courses/30/lessons/1845?language=java
 * 해시
 */
public class PhoneKetMon1845 {

    public int solution(int[] nums) {
        int answer = 0;
        int size = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < size; i++) {
            set.add(nums[i]);
        }
        int canCount = size / 2;
        if (canCount < set.size()) answer = canCount;
        else answer = set.size();
        return answer;
    }

    public static void main(String[] args) {
        PhoneKetMon1845 p = new PhoneKetMon1845();
        System.out.println(p.solution(new int[]{3, 1, 2, 3}));
        System.out.println(p.solution(new int[]{3, 3, 3, 2, 2, 4}));
        System.out.println(p.solution(new int[]{3, 3, 3, 2, 2, 2}));
    }
}
