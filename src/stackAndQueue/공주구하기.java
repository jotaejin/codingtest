package stackAndQueue;

import java.util.LinkedList;
import java.util.Scanner;

public class 공주구하기 {
    public static int solution(int n, int k){
        int answer = 0;
        LinkedList<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        while (!q.isEmpty()){
            for (int i = 1; i < k; i++)q.offer(q.poll());
            q.poll();//k를 외친 사람은 제거
            if(q.size() == 1) answer = q.poll();
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(solution(n,k));
    }
}
