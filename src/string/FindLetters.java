package string;

import java.util.Arrays;
import java.util.Scanner;

public class FindLetters {
    public int solution(String str, char t){
        int answer = 0;

        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            if(Character.toLowerCase(charArray[c]) == Character.toLowerCase(t)){
                answer++;
           }
        }
        return answer;
    }

    public static void main(String[] args) {
        FindLetters t = new FindLetters();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char c = kb.next().charAt(0);


        System.out.print(t.solution(str,c));
    }
}
