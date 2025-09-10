package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Body implements Comparable<Body>{
    public int height,weight;

    public Body(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Body o) {
        return o.height-this.height;//내림차순 음수 값
    }
}

public class 씨름선수 {
    public int solution(ArrayList<Body> arr, int n){
        int cnt = 0;
        Collections.sort(arr);
        int max = Integer.MIN_VALUE;

        for (Body ob : arr) {
            if(ob.weight>max){//몸무게가 최대값보다 클 때 선발됨
                max=ob.weight;
                cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        씨름선수 t = new 씨름선수();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Body> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            arr.add(new Body(h,w));
        }
        System.out.println(t.solution(arr,n));
    }

}
