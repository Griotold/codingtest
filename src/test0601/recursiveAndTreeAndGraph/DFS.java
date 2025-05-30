package test0601.recursiveAndTreeAndGraph;

import java.util.*;

public class DFS {
    static Node root;

    static void dfs(Node node) {
        if (node == null) return;
        else {
            // 전위 순회
            System.out.println(node.data + " ");
            dfs(node.lt);
            // 중위 순회
            //System.out.println(node.data + " ");
            dfs(node.rt);
            // 후위 순회
            //System.out.println(node.data + " ");
        }
    }

    static class Node {
        int data;
        Node lt;
        Node rt;
        Node (int val) {
            data = val;
            lt = null;
            rt = null;
        }
    }

    public static void main(String[] args) {
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt=new Node(4);
        root.lt.rt=new Node(5);
        root.rt.lt=new Node(6);
        root.rt.rt=new Node(7);
        dfs(root);
    }
}
