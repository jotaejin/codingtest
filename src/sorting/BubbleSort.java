package sorting;

import java.util.Scanner;

public class BubbleSort {
    public static int[] solution(int n, int[] arr){
        for (int i = 0; i < n-1; i++) {//턴 횟수
            for (int j = 0; j < n-i-1; j++) {//인접한 두개의 원소값 비교
                if(arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }//뒤에가 작으면 swap
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int x : solution(n,arr)) {
            System.out.print(x+" ");
        }
    }
}
