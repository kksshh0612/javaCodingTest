package Section6;

import java.util.Scanner;

// 13. 경로탐색         -->>>>>>>1부터 n번까지 가는 경로의 수
public class Num13 {

    public static int cnt;

    public static void DFS(boolean[][] graph, boolean[] isUsed, int curr, int end){
        if(curr == end){
            cnt++;
        }
        else{
            for(int i = 0; i <= end; i++){      //0에서 시작. 근데 이제 도착을 도는거
                if(isUsed[curr] == false && graph[curr][i] == true){             //다른 vertex로 가는 간선이 있으면
                    isUsed[curr] = true;
                    DFS(graph, isUsed, i, end);
                    isUsed[curr] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vertexNum = scanner.nextInt();          //정점 수
        int edgeNum = scanner.nextInt();            //간선 수
        boolean[][] graph = new boolean[vertexNum][vertexNum];
        boolean[] isUsed = new boolean[vertexNum];
        for(int i = 0; i < edgeNum; i++){
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            graph[start - 1][end - 1] = true;       //간선 정보를 넣음.
        }
        cnt = 0;

        DFS(graph, isUsed, 0, vertexNum - 1);

        System.out.println(cnt);

    }
}
