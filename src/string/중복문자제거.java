package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class 중복문자제거 {
    public static String solution(String str){
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for (Character c : str.toCharArray()) {
            set.add(c);
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : set) {
            sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}
