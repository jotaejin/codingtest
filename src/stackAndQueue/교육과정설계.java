package stackAndQueue;

import java.util.LinkedList;
import java.util.Scanner;

public class 교육과정설계 {
    public static String solution(String need, String plan){
        String answer = "YES";
        LinkedList<Character> Q = new LinkedList<>();
        for (char x : need.toCharArray()) {
            Q.offer(x);
        }
        for (char x : plan.toCharArray()) {
            if(Q.contains(x)){//필수 과목
                if(x!=Q.poll()) return "NO";
            }
        }
        if(!Q.isEmpty()) return "NO";// 과목 이수 안했을 때
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        System.out.println(solution(a,b));
    }
}
