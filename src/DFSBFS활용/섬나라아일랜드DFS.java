package DFSBFS활용;

import java.util.Scanner;

public class 섬나라아일랜드DFS {
    static int answer=0,n;
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};

    public static void DFS(int x, int y, int[][] board){
        for (int i = 0; i < 8; i++) {//8방향
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<n && board[nx][ny]==1){//뻗어 나가기
                board[nx][ny] = 0;//바다로 바꾸기
                DFS(nx,ny,board);
            }
        }
    }

    public static void solution(int[][] board){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == 1){//섬을 만났다면 카운팅하기
                    answer++;
                    board[i][j]=0;//출발점을 0으로 바꾸기
                    DFS(i,j, board);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();//격자의 크기
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        solution(arr);
        System.out.println(answer);
    }
}
