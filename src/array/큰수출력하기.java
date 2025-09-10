package array;

import java.util.ArrayList;
import java.util.Scanner;

public class 큰수출력하기 {

    private static ArrayList<Integer> solution(int num, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);
        for (int i = 1; i < num; i++) {
            if(arr[i] > arr[i-1]){
                answer.add(arr[i]);
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }
        for (int x : solution(num, arr)) {
            System.out.print(x+" ");
        }
    }


}
