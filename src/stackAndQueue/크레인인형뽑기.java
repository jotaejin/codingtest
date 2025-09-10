package stackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

public class 크레인인형뽑기 {
    public static int solution(int[][] board, int[] moves){
        int answer = 0;//인형 터뜨린 갯수
        Deque<Integer> basket = new ArrayDeque<>();

        for (int pos : moves) {
            for (int i = 0; i < board.length; i++) {//행크기 만큼 반복
                if(board[i][pos-1]!=0){
                    int tmp = board[i][pos-1];
                    board[i][pos-1] = 0;//인형이 있던 곳을 0으로
                    if(!basket.isEmpty() && tmp==basket.peek()){
                        answer+=2;
                        basket.pop();
                    }else basket.addLast(tmp);
                    break;//크레인이 더 내려가지 않게 break
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int m = sc.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = sc.nextInt();
        }

        System.out.println(solution(board,moves));
    }
}
