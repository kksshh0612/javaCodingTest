package Section3;

import java.util.Scanner;

//11. 격자판 회문 수
public class Num11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] arr = new int[7][7];
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 7; j++){
                arr[i][j] = scanner.nextInt();
            }
        }
        int cnt = 0;        //회문 수

        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 3; j++){
                //행 검사
                if((arr[i][j] == arr[i][j + 4]) && (arr[i][j + 1] == arr[i][j + 3])){       //회문이면
                    cnt++;
                }
                //열 검사
                if((arr[j][i] == arr[j + 4][i]) && (arr[j + 1][i] == arr[j + 3][i])){       //회문이면
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
