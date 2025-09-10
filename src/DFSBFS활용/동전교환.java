package DFSBFS활용;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 동전교환 {
    static int n,m,answer=Integer.MAX_VALUE;
    public void DFS(int L, int sum, Integer[] arr){
        if(sum>m) return;
        if(L>=answer) return;
        if(sum==m){
            answer = Math.min(answer,L);
        }else{
            for (int i = 0; i < n; i++) {//각 동전의 종류
                DFS(L+1,sum+arr[i],arr);
            }
        }
    }

    public static void main(String[] args) {
        동전교환 t = new 동전교환();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Integer[] arr = new Integer[n];//동전의 종류
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr,Collections.reverseOrder());
        m=sc.nextInt();//거슬러줄 금액
        t.DFS(0,0,arr);
        System.out.println(answer);
    }
    }

