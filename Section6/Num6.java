package Section6;

import java.util.Scanner;

//6. 중복순열 구하기(상태트리 그리고 다시 풀어보기)
public class Num6 {

    public static int cnt;      //경우의 수

    public static void DFS(int n, int m, int[] check, int currIdx){
        if(currIdx == m){
            for(int i = 0; i < check.length; i++){
                System.out.print(check[i] + " ");
            }
            System.out.println();
            cnt++;
        }
        else{
            for(int i = 0; i < n; i++){
                check[currIdx] = i + 1;
                DFS(n, m, check, currIdx + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();                  //1 ~ n
        int m = scanner.nextInt();                  //m개 뽑기.. m이 몇인지 모르기 때문에 그냥 반복문으로 해결할 수 없음
        cnt = 0;
        int currCnt = 0;
        int[] check = new int[m];           //중복 부분집합을 담을 배열

        DFS(n, m, check, 0);

        System.out.println(cnt);
    }
}
