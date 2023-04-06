package Section8;

import java.util.Scanner;

// 1. 네트워크 선 자르기 Bottom-Up
public class Num1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int line = scanner.nextInt();
        int[] cutNum = new int[line + 1];
        cutNum[0] = 0;
        cutNum[1] = 1;
        cutNum[2] = 2;
        int idx = 3;

        while(idx <= line){
            cutNum[idx] = cutNum[idx - 1] + cutNum[idx - 2];
            idx++;
        }
        System.out.println(cutNum[line]);

    }
}
