package string;

import java.util.Scanner;

public class 회문문자열 {
    public static String isPalindrom(String str){
        String reversed = new StringBuilder(str).reverse().toString();
        if(str.equalsIgnoreCase(reversed)){
            return "YES";
        }else{
            return "NO";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(isPalindrom(str));
    }
}
