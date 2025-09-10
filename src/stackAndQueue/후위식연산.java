package stackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class 후위식연산 {
    public static int solution(String str){
        int answer = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (char x : str.toCharArray()) {
            if(Character.isDigit(x)){
                stack.push(x-48);
            }else{
                int rt = stack.pop();
                int lt = stack.pop();
                if(x=='+') stack.push(lt+rt);
                else if (x == '-') stack.push(lt-rt);
                else if (x == '*') stack.push(lt*rt);
                else if (x == '/') stack.push(lt/rt);
            }
        }
        answer=stack.getFirst();

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}
