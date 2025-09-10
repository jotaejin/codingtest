package array;

import java.util.ArrayList;
import java.util.Scanner;

public class 뒤집은소수 {
    public static boolean isPrime(int num){
        if(num==1) return false;
        for (int i = 2; i < num; i++) {
            if(num%i == 0){
                return false;
            }else{
                return true;
            }
        }
        return true;
    }
    private static ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();//소수면 배열에 저장
        for (int i = 0; i < n; i++) {
            int tmp = arr[i];
            int res = 0;//역순 저장하는 변수
            while (tmp>0){//tmp를 역순으로
                int t = tmp % 10;
                res = res * 10 + t;
                tmp = tmp / 10;
            }
            if(isPrime(res)){//소수라면 배열에 저장한다
                answer.add(res);
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

        for (int x : solution(n,arr)){
            System.out.println(x+" ");
        }
    }
}
