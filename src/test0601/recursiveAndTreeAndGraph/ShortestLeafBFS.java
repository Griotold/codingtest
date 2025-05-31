package test0601.recursiveAndTreeAndGraph;

import java.util.*;

public class ShortestLeafBFS {
    static Node root;

    static class Node{
        int data;
        Node lt, rt;
        public Node(int val) {
            data=val;
            lt=rt=null;
        }
    }

    static int bfs(Node root) {
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        int level = 0;
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i=0; i<len; i++) {
                Node cur = queue.poll();
                if(cur.lt==null && cur.rt==null) return level;
                if(cur.lt!=null) queue.offer(cur.lt);
                if(cur.rt!=null) queue.offer(cur.rt);
            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args) {
        root=new Node(1);
        root.lt=new Node(2);
        root.rt=new Node(3);
        root.lt.lt=new Node(4);
        root.lt.rt=new Node(5);
        System.out.println(bfs(root));
    }

}
