package string;

import java.util.Scanner;

public class 숫자만추출 {
    private static int solution(String str) {
        String answer = "";
        for (char x : str.toCharArray()) {
            if(x>=48 && x<=57){
                if(Character.isDigit(x)){//str이 숫자라면 ex)'0'=48
                    answer += x;
                }
            }
        }
        return Integer.parseInt(answer);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(solution(str));
    }

    
}
