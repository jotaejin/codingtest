package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge>{

    public int vex;//거리
    public int cost;//가중치 값

    public Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge ob) {
        return this.cost - ob.cost;//가중치 값으로 오름차순
    }
}

public class 다익스트라 {
    static int n,m;
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;//각 노드의 최소 가중치 값을 저장할 수 있는 배열

    public void solution(int v){
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(v,0));//첫 노드의 좌표와 가중치 값 저장
        dis[v] = 0;//첫 노드의 가중치 값
        while (!pQ.isEmpty()){//다익스트라 시작
            Edge tmp = pQ.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;
            if(nowCost>dis[now]) continue;// 최소 거리 구하기위해서 현재 값보다 더 큰 값이 오면 안됨
            for (Edge ob : graph.get(now)) {
                if(dis[ob.vex]>nowCost+ob.cost){//다음 노드 cost 값보다 dis에 저장돼 있는 값이 크다면 교체
                    dis[ob.vex] = nowCost+ob.cost;//교체
                    pQ.offer(new Edge(ob.vex,nowCost+ob.cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        다익스트라 t = new 다익스트라();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();//노드의 개수
        m = sc.nextInt();//간선의 개수
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Edge>());
        }
        dis = new int[n+1];// 1번 노드부터 저장하기 위해서 +1
        Arrays.fill(dis, Integer.MAX_VALUE); //dis 배열을 최대 값으로 설정
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Edge(b,c));//a 간선과 연결되어있는 b와 가중치 값 c
        }
        t.solution(1);
        for (int i = 2; i <= n; i++) {//2번~n번 노드의 최소 가중치 값 출력
            if(dis[i]!=Integer.MAX_VALUE) System.out.println(i+" : "+dis[i]);
            else System.out.println(i+" : impossible");//연결되어 있는 노드가 없다면 impossible 출력
        }
    }
}
