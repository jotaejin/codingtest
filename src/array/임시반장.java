package array;

import java.util.Scanner;
/**
 * 이 문제는 i번학생이 j번 학생과 같은 반이됐으면 cnt++ 해주고 j번 학생들을 돌면서 비교하면 되는 문제이다.
 * **/
public class 임시반장 {
    private static int solution(int n, int[][] arr) {
        int answer = 0, max=Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {//i번 학생
            int cnt = 0;
            for (int j = 1; j <= n; j++) {//j번 학생
                for (int k = 1; k < 5; k++) { //1~5학년
                    if(arr[i][k] == arr[j][k]){
                        cnt++;
                        break;
                    }
                }
            }
            if(cnt>max){
                max=cnt;
                answer=i;//i번 학생
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n+1][6];//학생
        for(int i=1; i<=n; i++){//학생번호
            for (int j = 1; j <= 5; j++) {//1학년~5학년
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.print(solution(n,arr));

    }
}
