package DFSANDBFS;

import java.util.Scanner;

public class 경로탐색DFS {
    static int n,m,answer = 0;
    static int[][] graph;
    static int[] ch;
    public void DFS(int v){
        if(v==n) answer++;
        else{
            for (int i = 1; i <= n; i++) {//방문 안했을 때
                if(graph[v][i]==1 && ch[i]==0){
                    ch[i] = 1;
                    DFS(i);
                    ch[i] = 0;//백트래킹 했을 때 체크 풀어줌
                }
            }
        }
    }

    public static void main(String[] args) {
        경로탐색DFS t = new 경로탐색DFS();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();//노드의 개수
        m = sc.nextInt();//간선의 개수
        graph = new int[n+1][n+1];
        ch = new int[n+1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
        }
        ch[1] = 1;
        t.DFS(1);
        System.out.println(answer);
    }
}
