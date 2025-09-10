package DFSANDBFS;

public class 부분집합구하기DFS {
    static int n;
    static int[] ch;
    public void DFS(int L){
        if(L==n+1){//종착점일때 ch가 1로 체크된 것만 출력
            String tmp = "";
            for (int i = 1; i <= n; i++) {//ch[1], ch[2] 사용
                if (ch[i] == 1) tmp += (i + " ");
            }
            if(tmp.length()>0) System.out.println(tmp);
        }else{
            ch[L]=1;//사용했으면 1
            DFS(L+1);//왼쪽(사용)
            ch[L]=0;//사용 안하면
            DFS(L+1);//오른쪽(사용X)
        }
    }
    public static void main(String[] args) {
        부분집합구하기DFS t = new 부분집합구하기DFS();
        n = 4;
        ch = new int[n+1];// 인덱스 1부터 n까지 쓰기 위해 크기를 n+1로 생성
        t.DFS(1);
    }
}
