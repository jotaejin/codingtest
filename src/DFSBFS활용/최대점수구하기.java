package DFSBFS활용;

import java.util.Scanner;

public class 최대점수구하기 {
    static int answer = Integer.MIN_VALUE,n,m;
    public void DFS(int L, int sum, int time,int[] ps, int[] pt){
        if(time>m) return;//제한시간을 넘어가면 리턴
        if(L==n){//부분집합 완성
            answer = Math.max(answer,sum);
        }else{
            System.out.println("L="+L+" sum="+sum+" time="+time);
            DFS(L+1,sum+ps[L],time+pt[L], ps, pt);
            DFS(L+1,sum,time,ps,pt);
        }
    }

    public static void main(String[] args) {
        최대점수구하기 t = new 최대점수구하기();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();//문제 개수
        m = sc.nextInt();//제한 시간
        int[] a = new int[n];//점수
        int[] b = new int[n];//걸리는 시간
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        t.DFS(0,0,0,a,b);
        System.out.println(answer);
    }
}
