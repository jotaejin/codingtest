package array;

import java.util.Scanner;

public class 점수계산 {
    public static int solution(int n, int[] arr){
        int answer = 0, cnt = 0;//누적
        for (int i = 0; i < n; i++) {
            if(arr[i]==1){
                cnt++;
                answer+= cnt;
            } else if (arr[i] == 0) {
                cnt = 0;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(n,arr));
    }
}
