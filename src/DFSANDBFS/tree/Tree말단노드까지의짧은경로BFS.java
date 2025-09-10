package DFSANDBFS.tree;

//import DFSANDBFS.tree.Node4;

//import java.util.LinkedList;
//import java.util.Queue;
//
//class Node4 {
//    int data;
//    int lt,rt;
//
//    public Node4(int val) {
//        data = val;
//        lt=rt=0;
//    }
//}
//public class Tree말단노드까지의짧은경로BFS {
//    Node4 root;
//    public int BFS(Node4 root){
//        Queue<Node4> Q = new LinkedList<>();
//        Q.offer(root);
//        int L = 0;
//        while (!Q.isEmpty()){
//            int len = Q.size();
//            for (int i = 0; i < len; i++) {
//                Node4 cur = Q.poll();
//                if(cur.lt == null && cur.rt == null) return L;
//                if(cur.lt!=null) Q.offer(cur.lt);
//                if(cur.rt!=null) Q.offer(cur.rt);
//            }
//            L++;
//        }
//        return 0;
//    }
//    public static void main(String[] args) {
//        Tree말단노드까지의짧은경로BFS tree = new Tree말단노드까지의짧은경로BFS();
//        tree.root = new Node4(1);
//        tree.root.lt = new Node4(2);
//        tree.root.rt = new Node4(3);
//        tree.root.lt.lt = new Node4(4);
//        tree.root.lt.rt = new Node4(5);
//        System.out.println(tree.BFS(tree.root));
//    }
//}
