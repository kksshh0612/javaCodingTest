package Section3;

import java.util.Scanner;

//10. 스도쿠 검사
public class Num10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isComplete = true;
        int[][] arr = new int[9][9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                arr[i][j] = scanner.nextInt();
            }
        }
        int[] rowCheck = new int[10];       //0번 인덱스 버림. 1-9까지 사용
        int[] colCheck = new int[10];
        int[] boxCheck = new int[10];
        int sumRow = 0, sumCol = 0, sumBox = 0;
        //행과 열 검사
        for(int i = 0; i < 9; i++){
            sumRow = 0;
            sumCol = 0;
            for(int j = 1; j < 10; j++){        //초기화
                rowCheck[j] = 0;
                colCheck[j] = 0;
            }
            for(int j = 0; j < 9; j++){
                rowCheck[arr[i][j]] = 1;        //행을 체크. 해당하는 인덱스에 1 넣음.
                colCheck[arr[j][i]] = 1;        //열을 체크. 해당하는 인덱스에 1 넣음.
            }
            for(int j = 1; j < 10; j++){
                sumRow += rowCheck[j];
                sumCol += colCheck[j];
            }
            if(sumRow != 9 || sumCol != 9) {
                isComplete = false;
                break;
            }
        }
        //정사각형 검사
        for(int i = 0; i < 3; i += 3){          //행 시작
            for(int j = 0; j < 3; j += 3) {      //열 시작

                for(int k = 1; k < 10; k++){        //초기화
                    boxCheck[k] = 0;
                }
                for(int m = 0; m < 3; m++){        //초기화
                    for(int n = 0; n < 3; n++){
                        boxCheck[arr[i + m][j + n]] = 1;
                    }
                }
                for(int k = 1; k< 10; k++){
                    sumBox += boxCheck[k];
                }
                if(sumBox != 9) {
                    isComplete = false;
                    break;
                }
            }

        }

        if(isComplete == true){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
}
