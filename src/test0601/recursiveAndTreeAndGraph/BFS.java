package test0601.recursiveAndTreeAndGraph;


import java.util.ArrayDeque;
import java.util.Deque;

public class BFS {
    static Node root;

    static class Node{
        int data;
        Node lt;
        Node rt;

        Node(int val) {
            data = val;
            lt=rt=null;
        }
    }

    static void bfs(Node root) {
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            System.out.print(level + " : ");
            for (int i = 0; i < len; i++) {
                Node cur = queue.poll();
                System.out.print(cur.data + " ");
                if (cur.lt != null) queue.offer(cur.lt);
                if (cur.rt != null) queue.offer(cur.rt);
            }
            level++;
            System.out.println();
        }
    }

    public static void main(String args[]) {
        root = new Node(1);
        root.lt=new Node(2);
        root.rt=new Node(3);
        root.lt.lt=new Node(4);
        root.lt.rt=new Node(5);
        root.rt.lt=new Node(6);
        root.rt.rt=new Node(7);
        bfs(root);
    }
}
