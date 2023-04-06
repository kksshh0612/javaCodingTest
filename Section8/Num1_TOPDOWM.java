package Section8;

import java.util.Scanner;

// 1. top down
public class Num1_TOPDOWM {

    public static int DFS(int line, int[] memo){
        if(line == 1 || line == 2){
            return line;
        }
        else{
            memo[line] = DFS(line - 1, memo) + DFS(line - 2, memo);
            return memo[line];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int line = scanner.nextInt();
        int[] memo = new int[line + 1];

        int ans = DFS(line, memo);

        System.out.println(ans);

    }
}
