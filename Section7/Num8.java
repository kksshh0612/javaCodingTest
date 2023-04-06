package Section7;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//8. 사과나무 ---->>>> 이거 옛날에 풀었던 문젠데 BFS로 푸는거구나
public class Num8 {     //가운데에서 시작해서 상하좌우 탐색 반복.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
        boolean[][] check = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = scanner.nextInt();
            }
        }
        int[] dirX = {0, 1, 0, -1};
        int[] dirY = {-1, 0, 1, 0};
        Queue<int[]> queue = new LinkedList<>();
        int[] currPos = new int[2];         //x, y 좌표를 입력할 배열
        int[] nextPos = new int[2];
        int total = 0;

        currPos[0] = n / 2;
        currPos[1] = n / 2;     //시작 위치. 가운데
        System.out.println("시작 : " + currPos[0] + " " + currPos[1]);
        queue.add(currPos);

        while(!queue.isEmpty()){
            currPos = queue.poll();
            check[currPos[0]][currPos[1]] = true;       //수확했다고 표시

            System.out.println("수확 " + currPos[1] + " " + currPos[0]);

            total += arr[currPos[1]][currPos[0]];       //수확

            for(int i = 0; i < 4; i++){
                nextPos[0] = currPos[0] + dirY[i];
                nextPos[1] = currPos[1] + dirX[i];

                if((0 <= nextPos[0] && nextPos[0] < n) && (0 <= nextPos[1] && nextPos[1] < n)){ //위치가 범위 안에 있고
                    if(check[nextPos[1]][nextPos[0]] == false) {  //아직 수확하지 않아야
                        queue.add(nextPos);
                        System.out.println("탐색 " + nextPos[1] + " " + nextPos[0]);
                    }
                }
            }
        }
        System.out.println(total);


    }
}
