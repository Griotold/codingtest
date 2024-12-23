package hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 241107 목 - 완주하지 못한 선수 - 프로그래머스 42576
 * https://school.programmers.co.kr/learn/courses/30/lessons/42576
 * 해시
 * */
public class PlayerNotComplete42576 {

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        // 1. Hash 만들기 put(), getOrDefault()
        HashMap<String, Integer> map = new HashMap<>();

        for(String player : participant) {
            map.put(player, map.getOrDefault(player, 0) + 1);
        }

        // 2. Hash 빼기

        for (String player : completion) {
            map.put(player, map.get(player) - 1);
        }

        // 3. 마지막 주자 keySet(), entrySet()

        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if (entry.getValue() != 0) {
                answer = entry.getKey();
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}
