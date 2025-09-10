package twopointer;

import java.util.Scanner;

public class 연속부분수열 {
    public static int solution(int num, int sumResult, int[] arr) {
        int answer = 0;
        int sum = 0;
        int lt = 0;
        for(int rt = 0; rt < num; rt++) {
            sum += arr[rt];
            while (sum > sumResult) {//sum이 부분수열합 보다 클때 lt값 빼주고 lt주소값 증가
                sum -= arr[lt++];
            }
            if(sum == sumResult) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//총 데이터 개수
        int m = sc.nextInt();//부분 수열의 합
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(n,m,arr));
    }
}
