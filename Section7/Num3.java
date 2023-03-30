package Section7;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// 3. 양팔저울              --->>>>>>>>>> 다시 풀어보기
public class Num3 {

    public static Set<Integer> set;     //중복을 허용하지 않고 값을 저장하는 자료형

    public static void DFS(int[] arr, int weightSum, int currWeightCnt, int totalWeightCnt){
        if(currWeightCnt == totalWeightCnt){
            if(weightSum > 0){
//                System.out.println(weightSum);
                set.add(weightSum);
            }
        }
        else{
            //양팔저울의 왼쪽에 넣기
            DFS(arr, weightSum + arr[currWeightCnt], currWeightCnt + 1, totalWeightCnt);
            //양팔저울의 오른쪽에 넣기
            DFS(arr, weightSum - arr[currWeightCnt], currWeightCnt + 1, totalWeightCnt);
            //왼쪽, 오른쪽 어느 곳에도 넣지 않기
            DFS(arr, weightSum, currWeightCnt + 1, totalWeightCnt);
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();                  //추의 수
        int[] arr = new int[n];                     //추 무게 배열
        set = new HashSet<>();         //측정할 수 있는 추의 무게 저장할 set
        int maxWeight = 0;
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
            maxWeight += arr[i];            //담을 수 있는 최대 무게
        }

        DFS(arr, 0, 0, n);
        System.out.println(maxWeight - set.size());

    }
}


