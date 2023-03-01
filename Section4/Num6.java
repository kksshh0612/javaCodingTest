package Section4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//6. 씨름 선수
public class Num6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] physical = new int[n][2];       //키, 몸무게
        int cnt = 0;                            //탈락하는 사람 수
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 2; j++){
                physical[i][j] = scanner.nextInt();
            }
        }
        Arrays.sort(physical, Comparator.comparingInt((int[] o) -> o[0]));      //키를 기준으로 정렬
        for(int i = 0; i < n; i++){                      //나보다 키 큰 사람들 중에 몸무게 큰 사람 있는지 확인
            for(int j = i + 1; j < n; j++){
                if(physical[i][1] < physical[j][1]){    //나보다 키 큰 사람들 중에 몸무게 큰 사람이 있다면
                    cnt++;                              //탈락자 수 증가
                    break;
                }
            }
        }
        System.out.println(n - cnt);
    }
}
