package test0601.recursiveAndTreeAndGraph;

import java.util.*;

/**
 * dis 배열에 저장해놓는 방식
 * */
public class GraphShortestPathBFS2 {

    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch, dis;

    public void BFS(int v){
        ch[v]=1;
        dis[v]=0;
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(v);
        while(!queue.isEmpty()){
            int cv=queue.poll();
            for(int nv : graph.get(cv)){
                if(ch[nv]==0){
                    ch[nv]=1;
                    queue.offer(nv);
                    dis[nv]=dis[cv]+1;
                }
            }
        }
    }

    public static void main(String[] args){
        GraphShortestPathBFS2 T = new GraphShortestPathBFS2();
        Scanner kb = new Scanner(System.in);
        n=kb.nextInt();
        m=kb.nextInt();
        graph=new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        ch=new int[n+1];
        dis=new int[n+1];
        for(int i=0; i<m; i++){
            int a=kb.nextInt();
            int b=kb.nextInt();
            graph.get(a).add(b);
        }
        T.BFS(1);
        for(int i=2; i<=n; i++){
            System.out.println(i+" : "+dis[i]);
        }
    }
}
