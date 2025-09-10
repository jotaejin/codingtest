package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Time implements Comparable<Time>{
    public int s,e;

    public Time(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Time o) {
        if(this.e==o.e) return this.s-o.s;//끝나는 시간이 같다면 시작 시간 정렬
        else return this.e-o.e;//끝나는 시간으로 오름차순 정렬
    }
}
public class 회의실배정 {

    public int solution(ArrayList<Time> arr, int n){
        int cnt = 0;
        Collections.sort(arr);
        int endTime = 0;
        for (Time ob : arr) {
            if(ob.s>=endTime){//시작시간이 끝나는 시간보다 크다면
                cnt++;
                endTime=ob.e;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        회의실배정 t = new 회의실배정();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Time> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            arr.add(new Time(s,e));
        }
        System.out.println(t.solution(arr,n));
    }
}
