package string;

import java.util.Scanner;

public class 대소문자변환 {
    public static String solution(String str){
        String answer = "";
        for (char x : str.toCharArray()) {
            if(Character.isLowerCase(x)){
                answer+=Character.toUpperCase(x);
            }else{
                answer+=Character.toLowerCase(x);
            }
        }

        return answer;
    }
        public static void main(String[] args){
            Scanner kb =new Scanner(System.in);
            String str = kb.next();
            System.out.println(solution(str));

    }

}
