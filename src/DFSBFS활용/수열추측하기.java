package DFSBFS활용;

import java.util.Scanner;

public class 수열추측하기 {
    static int[] b,p,ch;
    static int n,f;
    boolean flag = false;
    int[][] dy = new int[35][35];
    public int combi(int n, int r){
        if(dy[n][r]>0) return dy[n][r];
        if(n==r || r==0) return 1;
        else return dy[n][r] = combi(n-1,r-1)+combi(n-1,r);
    }

    public void DFS(int L,int sum){
        if(flag) return;
        if(L==n){
            if(sum==f){
                for (int x : p) {
                    System.out.print(x+" ");
                }
                flag=true;
            }
        }else{
            for (int i = 1; i <= n; i++) {//i= 순열을 만드는 숫자
                if(ch[i]==0){
                    ch[i]=1;
                    p[L]=i;
                    DFS(L+1,sum+(p[L]*b[L]));
                    ch[i]=0;
                }
            }
        }
    }

    public static void main(String[] args) {
        수열추측하기 t = new 수열추측하기();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        f = sc.nextInt();//최종 값
        b = new int[n];//콤비네이션 값 저장
        p = new int[n];//순열
        ch = new int[n+1];//1~n까지 사용
        for (int i = 0; i < n; i++) {
            b[i] = t.combi(n-1, i);
        }
        t.DFS(0,0);
    }
}
