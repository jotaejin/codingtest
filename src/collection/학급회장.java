package collection;

import java.util.HashMap;
import java.util.Scanner;

public class 학급회장 {
    public static char solution(String s){
        char answer = ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : s.toCharArray()) {
            map.put(x,map.getOrDefault(x,0)+1);
        }

        int max = Integer.MIN_VALUE;
        for (char key : map.keySet()) {
            if(map.get(key) > max){
                max = map.get(key);
                answer = key;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}
