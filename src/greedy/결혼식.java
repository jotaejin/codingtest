package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Time2 implements Comparable<Time2> {
    public int time;
    public char state;//시작,끝나는 시간의 상태를 담는 변수

    public Time2(int time, char state) {
        this.time = time;
        this.state = state;
    }

    @Override
    public int compareTo(Time2 ob) {
        if(this.time==ob.time) return this.state - ob.state;//오름차순
        else return this.time - ob.time;
    }
}
public class 결혼식 {
    public int solution(ArrayList<Time2> arr){
        int answer = Integer.MIN_VALUE;
        Collections.sort(arr);
        int cnt = 0;

        for (Time2 ob : arr) {
            if(ob.state=='s'){
                cnt++;
            }else{
                cnt--;
            }
            answer=Math.max(answer, cnt);
        }

        return answer;
    }

    public static void main(String[] args) {
        결혼식 t = new 결혼식();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Time2> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int sT = sc.nextInt();
            int eT = sc.nextInt();
            arr.add(new Time2(sT,'s'));
            arr.add(new Time2(eT,'e'));
        }

        System.out.println(t.solution(arr));
    }
}
