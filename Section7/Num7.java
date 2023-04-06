package Section7;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 7. 송아지 찾기
public class Num7 {

    //DFS 풀이
//    public static int min;
//
//    //DFS로 풀면 안되는 이유 :
//    //진행 방향이 -, + 둘 다이기 때문에 한쪽 방향으로 무한히 진행하는 상황을 막을 수 없다
//    //예를 들어, 5에서 시작해서 14로 갈 때, -1, +1, +5로 갈 수 있는데 깊이우선 탐색을 하면
//    //-1씩 무한히 더한다. 근데 5에서 14로 최단거리를 갈 때, +5 +5 -1 과 같이 14를 넘어갈 수 도 있고,
//    //그렇기 때문에 DFS로 풀면 안된다.
//    public static void DFS(int start, int end, int cnt, int curr, int[] dir){
//        if(curr == end){        //지정한 수에 도달하면
//            if(cnt < min){
//                min = cnt;
//            }
//        }
//        else{
//            for(int i = 0; i < 3; i++){
//                DFS(start, end, cnt + 1, curr + dir[i], dir);
//            }
//        }
//    }


//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int start = scanner.nextInt();
//        int end = scanner.nextInt();
//        int[] dir = new int[3];
//        dir[0] = -1;
//        dir[1] = 1;
//        dir[2] = 5;
//        min = 10000;
//        DFS(start, end, 0, start, dir);
//    }
    //BFS 풀이
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
