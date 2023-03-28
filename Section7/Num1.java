package Section7;

import javax.swing.plaf.metal.MetalLookAndFeel;
import java.util.Scanner;

//1. 최대점수 구하기
public class Num1 {

    public static int maxScore;

//    public static void DFS(int[][] problems, boolean[] score, int currTime, int timeLimit){ --> 제한시간 찰 때까지 부분집합 묶기 (조합, 중복X)
//        int sum = 0;
//        if(currTime > timeLimit) {              //제한 시간보다 넘으면 직전꺼 하나 빼고 확인
//            return;
//        }
//        else if(currTime == timeLimit){
//            for(int i = 0; i < score.length; i++){
//                if(score[i]){
//                    sum += problems[i][0];
//                }
//            }
//            if(sum > maxScore){
//                maxScore = sum;
//            }
//        }
//        else{
//            for(int i = 0; i < score.length; i++){
//                if(score[i] == false){
//                    score[i] = true;
//                    DFS(problems, score, currTime + problems[i][1], timeLimit);
//                    score[i] = false;
//                }
//            }
//        }
//    }
    // 모든 문제가 포함되는 경우, 포함 안되는 경우 구하기
    public static void DFS(int[][] problems, int currTime, int currScore , int timeLimit, int problemNum, int currProblem){
        if(currTime > timeLimit) return;
        if(currProblem == problemNum){
            if(currScore > maxScore){
                maxScore = currScore;
            }
        }
        else{
            DFS(problems, currTime + problems[currProblem][1], currScore + problems[currProblem][0], timeLimit, problemNum, currProblem + 1);
            DFS(problems, currTime, currScore, timeLimit, problemNum, currProblem + 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int problemNum = scanner.nextInt();
        int timeLimit = scanner.nextInt();
        int[][] problems = new int[problemNum][2];      //점수, 걸리는 시간
        for(int i = 0; i < problemNum; i++){
            problems[i][0] = scanner.nextInt();         //점수
            problems[i][1] = scanner.nextInt();         //걸리는 시간
        }
        boolean[] score = new boolean[problemNum];
        maxScore = 0;

//        DFS(problems, score, 0, timeLimit);
        DFS(problems, 0, 0, timeLimit, problemNum, 0);

        System.out.println(maxScore);
    }
}
