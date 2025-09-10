package DFSBFS활용;

import java.util.Scanner;

public class 조합수with메모리제이션 {
    int[][] dy = new int[35][35];
    public int DFS(int n, int r){
        if(dy[n][r]>0) return dy[n][r];//재귀를 돌았으면 더 돌면안됨
        if(n==r || r==0) return 1;
        else return dy[n][r] = DFS(n-1,r-1) + DFS(n-1, r);//콤비네이션 공식
    }

    public static void main(String[] args) {
        조합수with메모리제이션 t = new 조합수with메모리제이션();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        System.out.println(t.DFS(n,r));
    }
}
