package Section2;

import java.util.Scanner;

//10. 점수계산
public class Num10 {
    public static void main(String[] args) {        //이전꺼 결과 검사하고 이전 문제 맞았으면 1 더함
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();      //문제 수
        int[] arr = new int[N];
        int[] score = new int[N];
        int scoreSum = 0;

        for(int i = 0; i < N; i++){
            arr[i] = scanner.nextInt();
            if(arr[i] == 1) {                       //문제를 맞췄을 때
                score[i]++;
                if (i > 0 && arr[i - 1] == 1) {      //두번째 수부터 이전에 정답이었는지 확인
                    score[i] += score[i - 1];
                }
                scoreSum += score[i];               //문제를 못맞추면 더할 필요가 없음.
            }
        }
//        for(int i = 0; i < N; i++){
//            scoreSum += score[i];
//        }
        System.out.println(scoreSum);
    }
}
