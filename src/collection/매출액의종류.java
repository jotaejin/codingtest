package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class 매출액의종류 {
    public static ArrayList<Integer> solution(int n, int k, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();//매출액 종류 담는 변수
        HashMap<Integer, Integer> HM = new HashMap<>();
        for (int i = 0; i < k - 1; i++) {//초기값
            HM.put(arr[i],HM.getOrDefault(arr[i],0)+1);
        }
        int lt=0;
        for (int rt = k-1; rt < n; rt++) {//슬라이딩 윈도우
            HM.put(arr[rt],HM.getOrDefault(arr[rt],0)+1);
            answer.add(HM.size());
            HM.put(arr[lt],HM.get(arr[lt])-1);
            if(HM.get(arr[lt])== 0) HM.remove(arr[lt]);//값이 0이라면 삭제한다
            lt++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {//매출 기록
            arr[i] = sc.nextInt();
        }
        for (Integer x : solution(n, k, arr)) {
            System.out.print(x+" ");
        }
    }
}
