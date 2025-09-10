package DFSANDBFS;

import java.util.LinkedList;
import java.util.Queue;

class Node2 {
    int data;
    Node lt,rt;

    public Node2(int val) {
        data = val;
        lt=rt=null;
    }
}
public class 이진트리순회BFS {
    Node root;
    public void BFS(Node root){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int L = 0;//레벨
        while (!q.isEmpty()){
            int len = q.size();//각 레벨의 원소 개수
            System.out.print(L+" : ");
            for (int i = 0; i < len; i++) {
                Node current = q.poll();
                System.out.print(current.data);
                if(current.lt!=null)q.offer(current.lt); //현재 노드 왼쪽 노드가 있을때
                if(current.rt!=null) q.offer(current.rt);
            }//레벨 끝
            L++;
            System.out.println();
        }
    }
    public static void main(String[] args) {
        이진트리순회BFS tree = new 이진트리순회BFS();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt= new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.BFS(tree.root);
    }
}
