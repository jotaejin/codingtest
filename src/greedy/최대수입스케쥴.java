package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Lecture implements Comparable<Lecture>{
    public int money;
    public int date;

    public Lecture(int money, int date) {
        this.money = money;
        this.date = date;
    }

    @Override
    public int compareTo(Lecture ob) {
        return ob.date - this.date;// 시간 기준으로 내림차순
    }
}

public class 최대수입스케쥴 {
    static int n, max = Integer.MIN_VALUE;
    public int solution(ArrayList<Lecture> arr){
        int answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());//pQ.offer() 할 때 내림차순 정렬
        Collections.sort(arr);

        int j = 0;
        for (int i = max; i >= 1; i--) {//날짜가 하루 씩 작아짐
            for( ; j<n; j++){
                if(arr.get(j).date < i) break;
                pQ.offer(arr.get(j).money);
            }
            if(!pQ.isEmpty()) answer+= pQ.poll();
        }
        return answer;
    }

    public static void main(String[] args) {
        최대수입스케쥴 t = new 최대수입스케쥴();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ArrayList<Lecture> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int d = sc.nextInt();
            arr.add(new Lecture(m,d));
            if(d>max) max = d;
        }
        System.out.println(t.solution(arr));
    }
}
