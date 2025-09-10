package string.문장속단어;

import java.util.Scanner;

public class 문장속단어 {
    public static String solution(String str){
        String answer = "";
        int max = Integer.MIN_VALUE;

        String[] s = str.split(" ");

        for (String string : s) {
            int len = string.length();
            if(len > max){//길이가 max보다 크면 교체
                max = len;
                answer = string;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(solution(str));
    }
}
