package Section3;

import java.util.Scanner;

//8. 곳감(모래시계)
public class Num8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] arr = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                arr[i][j] = scanner.nextInt();
            }
        }
        int M = scanner.nextInt();
        int sum = 0;                            //모래시계 모양으로 더할 변수

        for(int i = 0; i < M; i++){
            int rowNum = scanner.nextInt() - 1;     //회전 행 번호(번째)
            int dir = scanner.nextInt();        //0이면 왼쪽 1이면 오른쪽
            int rotateNum = scanner.nextInt();  //회전 수
            int tmp = 0;                        //가장 끝에 있는 값을 잠시 넣을 변수
            if(dir == 0){       //왼쪽으로 회전
                while(rotateNum-- > 0){         //회전 수 만큼 왼쪽으로 한 칸씩 이동
                    tmp = arr[rowNum][0];
                    for(int j = 1; j < N; j++){
                        arr[rowNum][j-1] = arr[rowNum][j];
                    }
                    arr[rowNum][N-1] = tmp;
                }
            }
            if(dir == 1){       //오른쪽으로 회전
                while(rotateNum-- > 0){         //회전 수 만큼 오른쪽으로 한 칸씩 이동
                    tmp = arr[rowNum][N-1];
                    for(int j = N-2; j >= 0; j--){
                        arr[rowNum][j+1] = arr[rowNum][j];
                    }
                    arr[rowNum][0] = tmp;
                }
            }
        }
        //모래시계 모양으로 더하기
        for(int i = 0; i < N/2; i++){
            for(int j = i; j < N-i; j++){
                sum += arr[i][j];
                sum += arr[N-i-1][j];
            }
        }
        sum += arr[N/2][N/2];       //가운데 하나 더하기기
        System.out.println(sum);
    }
}
