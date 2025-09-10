package string;

import java.util.Scanner;

public class 문자거리 {
    private static int[] solution(String str, char t) {
        int[] answer= new int[str.length()];
        int p = 1000;

        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == t){
                p=0;
                answer[i] = p;
            }else{
                p++;
                answer[i] = p;
            }
        }

        p=1000;
        for (int i = str.length()-1; i >= 0; i--) {
            if(str.charAt(i) == t){
                p=0;
            }else{
                p++;
                answer[i] = Math.min(answer[i],p);//기존값과 p중에서 작은 값 넣기
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);
        for (int x : solution(str, c)) {
            System.out.print(x+" ");
        }
    }


}
