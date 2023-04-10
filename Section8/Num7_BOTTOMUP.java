package Section8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 7. 알리바바와 40인의 도둑
public class Num7_BOTTOMUP {            //오른쪽 먼저 더하고 아래 더함. BFS로 하는데 큐에 좌표를 넣어야 함.

    public static void main(String[] args) {        //y좌표는 아래로 내려갈 때 더해야함.
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();        //한 변의 길이
        int[][] arr = new int[len][len];
        int[][] dt = new int[len][len];     //누적 에너지 저장할 다이나믹테이블
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                arr[i][j] = scanner.nextInt();
                dt[i][j] = 4000000;                 //들어갈 수 있는 가장 큰 수로 초기화
            }
        }

        Integer[] startPos = new Integer[2];     //다음 이동 좌표를 저장할 배열
        Integer[] currPos = new Integer[2];     //다음 이동 좌표를 저장할 배열
        Queue<Integer[]> queue = new LinkedList<>();      //BFS에 이용할 큐
        int x = 0, y = 0;

        startPos[0] = 0;
        startPos[1] = 0;
        queue.add(startPos);
        dt[0][0] = arr[0][0];

        while(!queue.isEmpty()){
            Integer[] nextPosRight = new Integer[2];     //오른쪽 이동 좌표를 저장할 배열
            Integer[] nextPosBottom = new Integer[2];     //아래 이동 좌표를 저장할 배열
            currPos = queue.poll();     //현재 탐색중인 좌표
            x = currPos[0];
            y = currPos[1];

            if(x + 1 < len){            //범위 내에 있으면 오른쪽으로 이동
                if(arr[y][x + 1] + dt[y][x] < dt[y][x + 1]){
                    dt[y][x + 1] = arr[y][x + 1] + dt[y][x];
                    nextPosRight[0] = x + 1;
                    nextPosRight[1] = y;
                    queue.add(nextPosRight);
                }
            }
            if(y + 1 < len){            //범위 내에 있으면 아래로 이동
                if(arr[y + 1][x] + dt[y][x] < dt[y + 1][x]){
                    dt[y + 1][x] = arr[y + 1][x] + dt[y][x];
                    nextPosBottom[0] = x;
                    nextPosBottom[1] = y + 1;
                    queue.add(nextPosBottom);
                }
            }
        }
        System.out.println(dt[len - 1][len - 1]);
    }
}


