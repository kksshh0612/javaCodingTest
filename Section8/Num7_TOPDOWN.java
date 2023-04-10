package Section8;

import java.util.Scanner;

// 7. 알리바바와 40인의 도둑 top down
public class Num7_TOPDOWN {

    public static int min;

    public static void DFS(int[][] arr, int[][] dt, int x, int y, int sumNum){    //도착지점에서 시작해서 위, 왼쪽으로 이동
        if(sumNum >= min) return;        //이미 넘어서면 리턴
        if(x < 0 || y < 0) return;      //범위를 벗어남.
        if(x == 0 && y == 0){
            dt[0][0] = sumNum + arr[0][0];
            if(dt[0][0] < min){
                min = dt[0][0];
            }
        }
        else{
            dt[y][x] = sumNum + arr[y][x];
            DFS(arr, dt, x - 1, y, dt[y][x]);       //왼쪽으로 이동
            DFS(arr, dt, x, y - 1, dt[y][x]);       //위쪽으로 이동
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[][] arr = new int[len][len];
        int[][] dt = new int[len][len];
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                arr[i][j] = scanner.nextInt();
                dt[i][j] = 4000000;
            }
        }
        dt[len - 1][len - 1] = arr[len - 1][len - 1];
        min = 4000000;

        DFS(arr, dt, len - 1, len - 1, 0);

        System.out.println(min);
    }
}
