package Section8;

import java.util.Arrays;
import java.util.Scanner;

// 12. 회장뽑기
public class Num12_BOTTOMUP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people = scanner.nextInt();             //후보 수
        int[][] dt = new int[people + 1][people + 1];       //몇다리 건너 친구인지 저장

        //초기화
        for(int i = 1; i < people + 1; i++){
            for(int j = 1; j < people + 1; j++){
                if(i == j){
                    dt[i][j] = 0;
                }
                else{
                    dt[i][j] = people + 1;              //나올 수 없는 수. 결국 친구 다리 건너도 친구가 아님.
                }
            }
        }

        int person1 = 0, person2 = 0;
        while(true){
            person1 = scanner.nextInt();
            person2 = scanner.nextInt();
            if(person1 == -1 && person2 == -1) break;
            dt[person1][person2] = 1;
            dt[person2][person1] = 1;
        }

        //플로이드 워셜 알고리즘
        for(int i = 1; i < people + 1; i++){
            for(int j = 1; j < people + 1; j++){
                for(int curr = 1; curr < people + 1; curr++){
                    if(dt[i][curr] + dt[curr][j] < dt[i][j]){
                        dt[i][j] = dt[i][curr] + dt[curr][j];
                    }
                }
            }
        }

//        for(int i = 1; i < people + 1; i++){
//            for(int j = 1; j < people + 1; j++){
//                System.out.print(dt[i][j]);
//            }
//            System.out.println();
//        }

        int[] candidate =  new int[people + 1];
        for(int i = 1; i < people + 1; i++){
            Arrays.sort(dt[i]);
            candidate[i] = dt[i][people];           //가장 큰 값. 친구 몇다리 건너는지
        }

        int min = people + 1;
        for(int i = 1; i < people + 1; i++){
            if(candidate[i] < min){
                min = candidate[i];                 //후보 중 모든 친구들이 다 가까운 애가 후보
            }
        }

        int cnt = 0;
        for(int i = 0; i < people + 1; i++){
            if(min == candidate[i]){
                cnt++;                              //후보가 몇명인지
            }
        }
        System.out.println(min + " " + cnt);
        for(int i = 0; i < people + 1; i++){
            if(min == candidate[i]){
                System.out.print(i + " ");
            }
        }
    }
}
