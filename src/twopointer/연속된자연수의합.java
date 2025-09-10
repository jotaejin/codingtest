package twopointer;

import java.util.Scanner;

public class 연속된자연수의합 {
    public static int solution(int n){
        int answer = 0, sum=0, lt=0;
        int m=n/2+1;
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i]=i+1;//0번 인덱스에 1 대입
        }
        for (int rt = 0; rt < m; rt++) {
            sum += arr[rt];
            while (sum > n) {//sum이 부분수열합 보다 클때 lt값 빼주고 lt주소값 증가
                sum -= arr[lt++];
            }
            if(sum == n) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }
}
