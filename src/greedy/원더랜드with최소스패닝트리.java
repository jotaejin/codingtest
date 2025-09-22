package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Edge2 implements Comparable<Edge2>{
    public int v1;
    public int v2;
    public int cost;

    public Edge2(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge2 ob) {
        return this.cost-ob.cost;
    }
}
public class 원더랜드with최소스패닝트리 {
    static int[] unf;
    public static int Find(int v){
        if(v==unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    }
    public static void Union(int a, int b){
        int fa = Find(a);
        int fb = Find(b);
        if(fa!=fb) unf[fa]=fb;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//도시의 개수
        int m = sc.nextInt();//도로 간선 개수
        unf = new int[n + 1];
        ArrayList<Edge2> arr = new ArrayList<>();
        for (int i = 1; i <= n; i++) unf[i] = i;
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            arr.add(new Edge2(a,b,c));
        }

        int answer = 0;//최소 비용 누적
        Collections.sort(arr);
        for (Edge2 ob : arr) {//회로가 아닌 것들만 선택
            int fv1 = Find(ob.v1);
            int fv2 = Find(ob.v2);//두 정점이 같은 집합이면 선택X
            if(fv1!=fv2){
                answer+=ob.cost;
                Union(ob.v1,ob.v2);//같은 집합으로 묶어줌
            }
        }

        System.out.println(answer);
    }
}
