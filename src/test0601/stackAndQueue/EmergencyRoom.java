package test0601.stackAndQueue;

import com.sun.tools.javac.Main;

import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class EmergencyRoom {
    // 5 2
    //60 50 70 80 90
    // 3

    static class Person {
        int id;
        int priority;

        Person(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }
    }

    static int solution(int n, int m, int[] arr){
        int answer=0;
        Queue<Person> Q=new LinkedList<>();
        for(int i=0; i<n; i++){
            Q.offer(new Person(i, arr[i]));
        }
        while(!Q.isEmpty()){
            Person tmp=Q.poll();
            for(Person x : Q){
                if(x.priority>tmp.priority){
                    Q.offer(tmp);
                    tmp=null;
                    break;
                }
            }
            if(tmp!=null){
                answer++;
                if(tmp.id==m) return answer;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int m=kb.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=kb.nextInt();
        }
        System.out.println(solution(n, m, arr));
    }
}
