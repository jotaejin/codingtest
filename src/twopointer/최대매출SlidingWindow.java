package twopointer;

import java.util.Scanner;

public class 최대매출SlidingWindow {
    private static int solution(int n, int k, int[] arr) {
        int answer=0 ,sum = 0;

        for (int i = 0; i < k; i++) {//초기 슬라이딩 윈도우
            sum += arr[i];
            answer = sum;
        }
        for (int i = k; i < n; i++) {// k 만큼 슬라이딩 윈도우
            sum+=(arr[i]-arr[i-k]);
            answer = Math.max(answer,sum);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//총 원소 개수
        int k = sc.nextInt();//슬라이딩 윈도우 개수
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print(solution(n,k,arr));
    }
}
