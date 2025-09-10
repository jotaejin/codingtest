package DFSANDBFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 송아지찾기BFS {
    int answer = 0;
    int[] dis = {1,-1,5};
    int[] ch;//한번 q에 들어간 것은 안넣기 위해 체크배열 생성
    Queue<Integer> Q = new LinkedList<>();
    public int BFS(int s, int e){
        ch = new int[10001];
        ch[s] = 1;//출발점
        Q.offer(s);
        int L = 0;
        while (!Q.isEmpty()){
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int x = Q.poll();
                for (int j = 0; j < 3; j++) {//좌표만큼 반복
                    int nx = x+dis[j];//자식노드
                    if(nx==e) return L+1;//송아지 위치라면 레벨 리턴
                    if(nx>=1 && nx<=10000 && ch[nx]==0){//방문 안했을 때 자식노드를 Q에 넣음
                        ch[nx] = 1;
                        Q.offer(nx);
                    }
                }
            }
            L++;
        }
        return 0;
    }

    public static void main(String[] args) {
        송아지찾기BFS t = new 송아지찾기BFS();
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();//출발점
        int e = sc.nextInt();//송아지 위치
        System.out.println(t.BFS(s,e));
    }
}
