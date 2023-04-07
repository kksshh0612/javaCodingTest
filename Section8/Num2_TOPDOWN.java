package Section8;

import java.util.Scanner;

// 2. 계단 오르기
public class Num2_TOPDOWN {

    public static int DFS(int stairs, int[] memo){
        if(stairs == 1 || stairs == 2){
            return stairs;
        }
        else{
            if(memo[stairs] == 0){
                memo[stairs] = DFS(stairs - 1, memo) + DFS(stairs - 2, memo);
            }
            return memo[stairs];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int stairs = scanner.nextInt();
        int[] memo = new int[stairs + 1];

        int ans = DFS(stairs, memo);
        System.out.println(ans);

    }
}
