package Section7;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 7. 송아지 찾기
public class Num7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        int[] check = new int[10001];
        int curr = 0, cnt = 0, min = 10000;
        int[] move = new int[3];        // -1, +1, +5

        queue.add(start);

        while(!queue.isEmpty()){        //큐가 비어있지 않을 때 반복
            curr = queue.poll();        //첫번째 값 반환
            if(curr == end){
                if(check[curr] < min){
                    min = check[curr];
                }
            }
            move[0] = curr - 1;
            move[1] = curr + 1;
            move[2] = curr + 5;
            for(int i = 0; i < 3; i ++){
                if((1 <= move[i] && move[i] <= 10000) && check[move[i]] == 0){
                    check[move[i]] = check[curr] + 1;           //몇번째 방문인지 표시
                    queue.add(move[i]);
                }
            }
        }
        System.out.println(min);

    }
}
