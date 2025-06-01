package test0601.dijkstra;

import java.util.*;

public class Dijkstra {

    static int n;
    static int m;
    static List<List<Edge>> graph;
    static int[] dist;

    static class Edge implements Comparable<Edge> {
        int vertex;
        int cost;

        Edge(int v, int c) {
            vertex = v;
            cost = c;
        }

        // 오름차순
        @Override
        public int compareTo(Edge o) {
            // return Integer.compare(this.cost, o.cost);
            return this.cost - o.cost;
        }
    }

    static void solution(int v) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(v, 0));
        dist[v] = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int now = cur.vertex;
            int nowCost = cur.cost;
            if(nowCost > dist[now]) continue;
            for(Edge next : graph.get(now)) {
                if (dist[next.vertex] > nowCost + next.cost) {
                    dist[next.vertex] = nowCost + next.cost;
                    pq.offer(new Edge(next.vertex, nowCost + next.cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i=0; i<m; i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            graph.get(a).add(new Edge(b, c));
        }
        solution(1);
        for(int i=2; i<=n; i++){
            if(dist[i]!=Integer.MAX_VALUE) System.out.println(i+" : "+dist[i]);
            else System.out.println(i+" : impossible");
        }
    }
}
