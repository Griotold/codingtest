package kundol.week1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1-A : 일곱 난쟁이
 * https://www.acmicpc.net/problem/2309
 * 브루트포스, 정렬
 * 조합
 * */
public class SevenDwarf2309 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> dwarfs = new ArrayList<>();
        int total = 0;
        for (int i = 0; i < 9; i++) {
            int dwarf = Integer.parseInt(br.readLine());
            total += dwarf;
            dwarfs.add(dwarf);
        }
        // 오름차순 정렬
        Collections.sort(dwarfs);

        // 브루트포스
        int index1 = 0;
        int index2 = 0;
        boolean flag = false;
        for (int i = 0; i < dwarfs.size(); i++) {
            for (int j = i + 1; j < dwarfs.size(); j++) {
                int a = dwarfs.get(i);
                int b = dwarfs.get(j);
                if (total - a - b == 100) {
                    index1 = i;
                    index2 = j;
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            if (i == index1 || i == index2) continue;
            sb.append(dwarfs.get(i)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
