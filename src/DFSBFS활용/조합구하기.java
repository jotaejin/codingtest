package DFSBFS활용;

import java.util.Scanner;

public class 조합구하기 {
    static int[] combi;
    static int n,m;
    public void DFS(int L, int start){
        if(L==m){
            for (int x : combi) {
                System.out.print(x+" ");
            }
            System.out.println();
        }else{
            for (int i = start; i <= n; i++) {
                combi[L] = i;
                DFS(L+1,i+1);
            }
        }
    }

    public static void main(String[] args) {
        조합구하기 t = new 조합구하기();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();//n개의 구슬
        m = sc.nextInt();//m개 뽑기
        combi = new int[m];
        t.DFS(0,1);
    }
}
