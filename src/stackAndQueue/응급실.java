package stackAndQueue;

import java.util.LinkedList;
import java.util.Scanner;

class Person {
    int id;
    int priority;

    public Person(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
}

public class 응급실 {
    public static int solution(int n, int m, int[] arr){
        int answer = 0;
        LinkedList<Person> Q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Q.offer(new Person(i,arr[i]));
        }
        while (!Q.isEmpty()){
            Person tmp = Q.poll();
            for (Person x : Q) {
                if(x.priority>tmp.priority){//맨 앞 환자의 위험 순위보다 뒷 환자의 위험순위가 더 크다면 앞 환자는 우선순위 뒤로 밀려남
                    Q.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if(tmp!=null){//위험순위가 제일 높다면
                answer++;
                if(tmp.id==m){
                    return answer;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(n,m,arr));
    }
}
