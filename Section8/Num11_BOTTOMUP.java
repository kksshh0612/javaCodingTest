package Section8;

import java.util.Scanner;

// 11. 플로이드 워셜 알고리즘
public class Num11_BOTTOMUP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vertex = scanner.nextInt();
        int edge = scanner.nextInt();
        int[][] dt = new int[vertex + 1][vertex + 1];
        for(int i = 0; i <= vertex; i++){               //0행, 0열은 버림.
            dt[0][i] = 0;
            dt[i][0] = 0;
        }
        for(int i = 1; i <= vertex; i++){           //행렬을 초기화 
            for(int j = 1; j <= vertex; j++){
                if(i == j){
                    dt[i][j] = 0;
                }
                else{
                    dt[i][j] = 10000;      //가장 큰 값으로 초기화 
                }
            }
        }
        int start = 0, end = 0;
        for(int i = 0; i < edge; i++){
            start = scanner.nextInt();
            end = scanner.nextInt();
            dt[start][end] = scanner.nextInt();     //간선의 비용 입력
        }

        //플로이드-워셜 알고리즘 부분
        for(int i = 1; i <= vertex; i++){
            for(int j = 1; j <= vertex; j++){
                for(int midVertex = 1; midVertex <= vertex; midVertex++){
                    int tmp = dt[i][midVertex] + dt[midVertex][j];
                    if(tmp < dt[i][j]){
                        dt[i][j] = tmp;
                    }
                }
            }
        }

        //전체 출력
        for(int i = 1; i < vertex + 1; i++){
            for(int j = 1; j < vertex + 1; j++){
                if(dt[i][j] == 10000){              //갈 수 없으면 M 출력
                    System.out.print((char)(65+12) + " ");
                }
                else{
                    System.out.print(dt[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
