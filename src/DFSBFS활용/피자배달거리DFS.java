package DFSBFS활용;

import java.util.ArrayList;
import java.util.Scanner;

public class 피자배달거리DFS {

    static int n,m,len, answer = Integer.MAX_VALUE;
    static int[] combi;
    static ArrayList<Point> pz, hs; //집과 피자집의 좌표를 담아놓는 배열
    public void DFS(int L, int s){//L=몇 개의 파지집을 선택했는지, s=시작 인덱스
        if(L==m){//조합이 완성됐을때 각 집의 피자 배달거리 구하고 다 합해서 최소거리 구하기 ex)0123 조합이 완성 됐을때 각 집의 피자집 최소거리 구하기
            int sum = 0;
            for (Point h : hs) {//집과 피자집을 비교하면서 최소값 구하기
                int dis = Integer.MAX_VALUE;
                for (int i : combi) {//조합의 인덱스 번호들이 i로 대응
                    dis=Math.min(dis, Math.abs(h.x- pz.get(i).x)+ Math.abs(h.y- pz.get(i).y));
                }
                sum+=dis;
            }
            answer= Math.min(answer, sum);
        }else{
            for (int i = s; i < len; i++) {
                combi[L] = i;//0~5사이의 m개를 뽑기
                DFS(L+1,i+1);
            }
        }
    }

    public static void main(String[] args) {
        피자배달거리DFS t = new 피자배달거리DFS();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();//도시에서 살려야하는 피자집의 개수

        pz = new ArrayList<>();
        hs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int tmp = sc.nextInt();//각각의 도시 정보를 담아놓는 변수
                if(tmp==1) hs.add(new Point(i,j)); //tmp가 1일때는 집의 좌표 담기
                else if(tmp==2) pz.add(new Point(i,j)); //tmp가 1일때는 집의 좌표 담기
            }
        }

        len = pz.size();// 피자집의 개수
        combi = new int[m];//len C m (조합 구하기)
        t.DFS(0,0);
        System.out.println(answer);
    }
}
