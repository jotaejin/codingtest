package string.문장속단어;

import java.util.Scanner;

public class 문장속단어IndexOf {
    public static String solution(String str){
        String answer = "";
        int max = Integer.MIN_VALUE, pos;

        while ((pos = str.indexOf(' '))!= -1){//띄어쓰기의 위치를 리턴
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if(len > max){
                max = len;
                answer = tmp;
            }
            str = str.substring(pos+1);
        }
        if(str.length()>max){ // 마지막 단어 처리
            answer = str;
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(solution(str));
    }
}
