package DFSBFS활용;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 토마토BFS {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] board, dis;
    static int n,m;
    static Queue<Point> q = new LinkedList<>();

    public void BFS(){
        while (!q.isEmpty()){
            Point tmp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x+dx[i];//현재 지점에 좌표 더하기
                int ny = tmp.y+dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m && board[nx][ny]== 0){
                    board[nx][ny]=1;//체크
                    q.offer(new Point(nx,ny));
                    dis[nx][ny]=dis[tmp.x][tmp.y]+1;//거리+1
                }
            }
        }
    }

    public static void main(String[] args) {
        토마토BFS t = new 토마토BFS();
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();//상자의 가로
        n = sc.nextInt();//상자의 세로
        board = new int[n][m];
        dis = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
                if(board[i][j]==1) q.offer(new Point(i,j));
            }
        }
        t.BFS();
        boolean flag = true;
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j]==0) flag = false;//익지 않은 토마토라면
            }
        }
        if(flag){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    answer = Math.max(answer,dis[i][j]);
                }
            }
            System.out.println(answer);
        }else System.out.println(-1);
    }
}


