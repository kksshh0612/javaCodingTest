package Section6;

import java.util.Scanner;

// 10. 조합 구하기       ->>>>>>>>>>>>>>>> 매우 중요!!!!!!!!!!!!!!!! 상태트리 그려보기
public class Num10 {

    public static int cnt;

    public static void DFS(int[] currCombination, int n, int m, int currNum, int currIdx){
        if(currIdx == m){
            cnt++;
            for(int i = 0; i < currCombination.length; i++){
                System.out.print(currCombination[i] + " ");
            }
            System.out.println();
        }
        else{       //현재 나보다 작은 것들과 나 빼고 넣을 수 있음
            for(int i = currNum; i <= n; i++){
                currCombination[currIdx] = i;
                DFS(currCombination, n, m, i + 1, currIdx + 1);
            }

        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        boolean[] check = new boolean[n + 1];       //1~N까지 사용되었는지 아닌지 확인하는 배열
        int[] currCombination = new int[m];

        for(int i = 0; i < check.length; i++){
            check[i] = false;
        }

        DFS(currCombination, n, m, 1, 0);
        System.out.println(cnt);

    }
}
