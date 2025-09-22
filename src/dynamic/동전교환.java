package dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class 동전교환 {
    static int n,m;
    static int[] dy;
    public int solution(int[] coin){
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = coin[i]; j <= m; j++) {
                dy[j] = Math.min(dy[j], dy[j-coin[i]]+1);
            }
        }
        return dy[m];//거슬러 줄 동전의 개수
    }

    public static void main(String[] args) {
        동전교환 t = new 동전교환();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {//동전 개수만큼 반복
            arr[i] = sc.nextInt();
        }
        m = sc.nextInt();//거슬러 줄 금액
        dy = new int[m+1];
        System.out.println(t.solution(arr));
    }
}
