package kundol.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 3-M: 부등호 - 백준 2529
 * https://www.acmicpc.net/problem/2529
 * 완전탐색, 백트래킹
 * */
public class InequalitySign2529 {
    static int K;
    static char arr[];
    static boolean visit[] = new boolean[10];
    static ArrayList<String> result = new ArrayList<>();
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new char[K];

        for(int i=0; i<K;i++){
            arr[i]=st.nextToken().charAt(0);

        }

        for(int i=0; i<10; i++){
            visit[i] = true;
            dfs(i,0,i+"");
            visit[i] = false;
        }

        System.out.println(result.get(result.size()-1));
        System.out.println(result.get(0));
    }

    static void dfs(int now, int count, String number){
        if(count==K){
            result.add(number);
            return;
        }

        for(int next=0; next<10; next++){
            if(!visit[next]){
                if((arr[count]=='<'&&now<next)||(arr[count]=='>'&& now>next)){
                    visit[next]=true;
                    dfs(next,count+1,number+next);
                    visit[next]=false;
                }
            }
        }
    }
}
