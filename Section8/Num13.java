package Section8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 13. 위상정렬 알고리즘 -> 일의 선후관계가 얽혀있을 때, 선후관계를 유지하면서 일을 처리하는 순서를 짜는 알고리즘
public class Num13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vertex = scanner.nextInt();
        int edge = scanner.nextInt();
        int[] degree = new int[vertex + 1];         //진입 차수를 저장하는 배열. 다이나믹 테이블.
        int start = 0, end = 0;
        int[][] graph = new int[vertex + 1][vertex + 1];
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < edge; i++){
            start = scanner.nextInt();
            end = scanner.nextInt();
            graph[start][end] = 1;
            degree[end]++;              //진입 차수
        }

        while (edge > 0){
            for(int i = 1; i < vertex + 1; i++){
                if(degree[i] == 0){
                    queue.add(i);
                    degree[i] = -1;
                }
            }
            while(!queue.isEmpty()){        //큐가 비어있지 않을 때 반복
                int startVtx = queue.poll();
                System.out.print(startVtx + " ");
                for(int i = 1; i < vertex + 1; i++){
                    if(graph[startVtx][i] == 1){
                        degree[i]--;                    //진입차수 줄이고
                        graph[startVtx][i] = 0;         //간선 제거
                        edge--;
                    }
                }
            }
        }
        for(int i = 1; i < vertex + 1; i++){
            if(degree[i] == 0){
                System.out.print(i);
            }
        }
    }
}
