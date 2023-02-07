package Section3;

import java.util.Scanner;

//6. 격자판 최대합
public class Num6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner((System.in));
        int N = scanner.nextInt();
        int[][] arr = new int[N][N];        //2차원 배열 선언
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                arr[i][j] = scanner.nextInt();
            }
        }
        int sumRow = 0, sumCol = 0, sumCross1 = 0, sumCross2 = 0, max = 0;

        for(int i = 0; i < N; i++){
            sumRow = 0;
            sumCol = 0;
            for(int j = 0; j < N; j++){
                sumRow += arr[i][j];
                sumCol += arr[j][i];
            }
            if(max < sumRow) max = sumRow;
            if(max < sumCol) max = sumCol;

            sumCross1 += arr[i][i];
            sumCross2 += arr[i][N-i-1];
        }
        if(max < sumCross1) max = sumCross1;
        if(max < sumCross2) max = sumCross2;

        System.out.println(max);
    }
}
