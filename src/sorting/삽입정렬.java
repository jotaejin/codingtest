package sorting;

import java.util.Scanner;

public class 삽입정렬 {

    public static int[] solution(int n, int[] arr){
        for (int i = 1; i < n; i++) {
            int tmp = arr[i], j;
            for (j = i-1; j >= 0; j--) {
                if(arr[j]>tmp) arr[j+1]=arr[j];//뒤로 미는 작업
                else break;//크지 않으면 빠져나온다
            }
            arr[j+1] = tmp;
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
