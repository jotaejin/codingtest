package DFSBFS활용;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 섬나라아일랜드BFS {

    static int answer=0,n;
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    static Queue<Point> queue = new LinkedList<>();
    public static void BFS(int x, int y, int[][] board){
        queue.add(new Point(x,y));
        while (!queue.isEmpty()){
            Point pos = queue.poll();
            for (int i = 0; i < 8; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<n && board[nx][ny]==1){//뻗어 나가기
                    board[nx][ny] = 0;//바다로 바꾸기
                    queue.add(new Point(nx,ny));
                }
            }
        }
    }


public void solution(int[][] board){
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if(board[i][j] == 1){//섬을 만났다면 카운팅하기
                answer++;
                board[i][j]=0;//출발점을 0으로 바꾸기
                BFS(i,j, board);
            }
        }
    }
}

public static void main(String[] args) {
    섬나라아일랜드BFS t = new 섬나라아일랜드BFS();
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    int[][] arr = new int[n][n];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            arr[i][j] = sc.nextInt();
        }
    }
    t.solution(arr);
    System.out.println(answer);
}
}
