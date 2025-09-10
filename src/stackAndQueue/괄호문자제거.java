package stackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class 괄호문자제거 {
    public static String solution(String str){
        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if(x==')'){
                while (stack.pop()!='(');//닫는괄호나 알파벳이라면 pop
            }else{
                stack.push(x);
            }
        }
        for (Character c : stack) {
            answer.append(c);
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}
