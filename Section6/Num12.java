package Section6;

import java.util.Scanner;

// 12. 인접행렬
public class Num12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vertexNum = scanner.nextInt();
        int edgeNum = scanner.nextInt();
        int[][] input = new int[edgeNum][3];
        int[][] output = new int[vertexNum][vertexNum];
        for(int i = 0; i < edgeNum; i++){       //출발정점, 도착정점, 비용(cost)
            for(int j = 0; j < 3; j++){
                input[i][j] = scanner.nextInt();
            }
            output[input[i][0] - 1][input[i][1] - 1] = input[i][2];
        }

        for(int i = 0; i < vertexNum; i++){
            for(int j = 0; j < vertexNum; j++){
                System.out.print(output[i][j] + " ");
            }
            System.out.println();
        }
    }
}
