package greedy;

import java.util.Scanner;

public class 친구인가 {
    static int[] unf;//집합을 표현하는 배열
    public static int Find(int v){//v번 학생의 집합 번호 리턴
        if(v==unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    }
    public static void Union(int a, int b){//집합 만드는 메서드
        int fa = Find(a);
        int fb = Find(b);
        if(fa!=fb) unf[fa] = fb;//a,b 학생들이 연결
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//사람 명 수
        int m = sc.nextInt();//순서 쌍
        unf = new int[n+1];
        for (int i = 1; i <= n; i++) unf[i] = i;//집합 초기화
        for (int i = 1; i <= m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            Union(a,b);//a,b를 한 집합으로 만들기
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
        int fa = Find(a);
        int fb = Find(b);
        if(fa==fb) System.out.println("YES");
        else System.out.println("NO");
    }
}
