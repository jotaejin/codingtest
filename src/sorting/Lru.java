package sorting;

import java.util.Scanner;

public class Lru {
    private static int[] solution(int size, int n, int[] arr) {
        int[] cache = new int[size];
        for (int x : arr) {
            int pos = -1;
            for (int i = 0; i < size; i++) if(x==cache[i]) pos=i; //히트라면
            if(pos==-1){//미스라면
                for (int i = size-1; i >= 1; i--) {
                    cache[i]=cache[i-1];
                }
                cache[0]=x;
            }else{
                for (int i = pos; i>= 1; i--) {//히트난 지점 인덱스 바꾸기
                    cache[i]=cache[i-1];
                }
                cache[0]=x;
            }
        }
        return cache;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int x : solution(s,n,arr)) {
            System.out.print(x+" ");
        }
    }
}