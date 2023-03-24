package Section6;

import java.util.Scanner;

//8. 순열 구하기
public class Num8 {

    public static int totalCnt;

    public static void DFS(int n, boolean[] check, int[] tokenArr, int tokenNum, int cnt, int currIdx){
        if(cnt == tokenNum){
            totalCnt++;

            for(int i = 0; i < tokenArr.length; i++){
                System.out.print(tokenArr[i] + " ");
            }
            System.out.println();
        }
        else{
            for(int i = 0; i < n; i++){
                if(check[i + 1] == false){      //현재 부분집합에 포함되지 않은 수여야 함.
                    check[i + 1] = true;
                    tokenArr[currIdx] = i + 1;
                    DFS(n, check, tokenArr, tokenNum, cnt + 1, currIdx + 1);
                    check[i + 1] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        boolean[] check = new boolean[n + 1];
        for(int i = 0; i < check.length; i++){
            check[i] = false;
        }
        int[] tokenArr = new int[m];

        totalCnt = 0;

        DFS(n, check, tokenArr, m, 0, 0);
        System.out.println(totalCnt);

    }
}
