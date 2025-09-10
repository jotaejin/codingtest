package DFSBFS활용;

import java.util.LinkedList;
import java.util.Scanner;

class Point{
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class 미로최단거리BFS {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] board, dis;

    public void BFS(int x, int y){
        LinkedList<Point> q = new LinkedList<>();

        q.offer(new Point(x,y));
        board[x][y]=1;//출발점 체크
        while (!q.isEmpty()){
            Point tmp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x+dx[i];//현재 지점에 좌표 더하기
                int ny = tmp.y+dy[i];
                if(nx>=1 && nx<=7 && ny>=1 && ny<=7 && board[nx][ny]== 0){
                    board[nx][ny]=1;//체크
                    q.offer(new Point(nx,ny));
                    dis[nx][ny]=dis[tmp.x][tmp.y]+1;//거리+1
                }
            }
        }
    }

    public static void main(String[] args) {
        미로최단거리BFS t = new 미로최단거리BFS();
        Scanner sc = new Scanner(System.in);
        board = new int[8][8];
        dis = new int[8][8];
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        t.BFS(1,1);
        if(dis[7][7] == 0) System.out.println(-1);//도착 못하면 -1(막혀있다면)
        else System.out.println(dis[7][7]);//도착했다면 최단 거리 출력
    }
}
