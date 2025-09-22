package dynamic;

import java.util.Scanner;

public class 최대점수구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);;
        int n = sc.nextInt();//문제 개수
        int m = sc.nextInt();//주어진 시간
        int[] dy = new int[m + 1];
        for (int i = 0; i < n; i++) {
            int ps = sc.nextInt();//문제의 점수
            int pt = sc.nextInt();//푸는 시간
            for (int j = m; j >= pt; j--) {
                dy[j] = Math.max(dy[j], dy[j-pt]+ps);
            }
        }
        System.out.println(dy[m]);//m분의 최대 점수
    }
}
