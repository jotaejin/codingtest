package dynamic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Brick implements Comparable<Brick>{

    public int s, height, weight;

    public Brick(int s, int height, int weight) {
        this.s = s;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Brick o) {
        return o.s-this.s;//내림차순 정렬
    }
}

public class 가장높은탑쌓기 {
    static int[] dy;
    private int solution(ArrayList<Brick> arr) {
        int answer = 0;
        Collections.sort(arr);
        dy[0] = arr.get(0).height;//첫번째 벽돌 초기화
        answer = dy[0];
        for (int i = 1; i < arr.size(); i++) {
            int max_h = 0;
            for (int j = i-1; j >= 0 ; j--) {
                if(arr.get(j).weight > arr.get(i).weight && dy[j] > max_h){//i벽돌을 j벽돌 위에 올려놓기
                    max_h = dy[j];
                }
            }
            dy[i] = max_h + arr.get(i).height;
            answer=Math.max(answer,dy[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        가장높은탑쌓기 t = new 가장높은탑쌓기();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Brick> arr = new ArrayList<>();
        dy = new int[n];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            arr.add(new Brick(a,b,c));
        }
        System.out.print(t.solution(arr));
    }
}
