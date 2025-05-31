package test0601.recursiveAndTreeAndGraph;

import com.sun.tools.javac.Main;

import java.util.*;

public class ShortestLeafDFS {

    static Node root;

    static class Node {
        int data;
        Node lt, rt;
        public Node(int val) {
            data=val;
            lt=rt=null;
        }
    }

    static int dfs(int level, Node root) {
        if(root.lt == null && root.rt == null) return level;
        else return Math.min(dfs(level+1, root.lt), dfs(level+1, root.rt));
    }

    public static void main(String args[]) {
        root=new Node(1);
        root.lt=new Node(2);
        root.rt=new Node(3);
        root.lt.lt=new Node(4);
        root.lt.rt=new Node(5);
        System.out.println(dfs(0, root));
    }
}
