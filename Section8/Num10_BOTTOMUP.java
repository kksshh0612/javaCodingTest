package Section8;

import java.util.Scanner;

// 10. 최대점수 구하기
public class Num10_BOTTOMUP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int problemNum = scanner.nextInt();
        int timeLimit = scanner.nextInt();
        int[] score = new int[problemNum];
        int[] time = new int[problemNum];
        for(int i = 0; i < problemNum; i++){
            score[i] = scanner.nextInt();
            time[i] = scanner.nextInt();
        }
        int[][] dt = new int[problemNum][timeLimit + 1];    //배열의 한 칸은 해당 시간에 얻을 수 있는 최대 점수

        int currScore = score[0], currTime = time[0];

        for(int i = currTime; i <= timeLimit; i++){
            dt[0][i] = currScore;
        }
        int tmp = 0;
        for(int i = 1; i < problemNum; i++){
            currScore = score[i];
            currTime = time[i];

            for(int j = 0; j < currTime; j++){
                dt[i][j] = dt[i - 1][j];
            }

            for(int j = currTime; j <= timeLimit; j++){
                tmp = dt[i - 1][j - currTime] + currScore;
                if(tmp > dt[i - 1][j]){
                    dt[i][j] = tmp;
                }
                else{
                    dt[i][j] = dt[i - 1][j];
                }
            }
//            for(int j = 0; j <= timeLimit; j++){
//                System.out.print(dt[i][j] + " ");
//            }
//            System.out.println();

        }
        System.out.println(dt[problemNum - 1][timeLimit]);

    }
}
