package Section4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//5. 회의실 배정
public class Num5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] meeting = new int[n][2];
        int cnt = 0, currEnd = 0;        //배정된 회의실 수, 현재 회의가 끝나는 시간
        for(int i = 0; i < n; i++){
            meeting[i][0] = scanner.nextInt();
            meeting[i][1] = scanner.nextInt();
        }

        //회의가 끝나는 시간 기준으로 정렬  -> 참고 : https://haenny.tistory.com/351
        Arrays.sort(meeting, Comparator.comparingInt((int[] o) -> o[1]));

        for(int i = 0; i < n; i++){
            if(currEnd <= meeting[i][0]){       //현재 마지막으로 배정된 회의의 끝나는 시간이 탐색중인 회의의 시작 시간보다 작거나 같으면 회의 배정
                cnt++;
                currEnd = meeting[i][1];        //배정된 회의의 끝나는 시간 저장
            }
        }
        System.out.println(cnt);

    }
}
