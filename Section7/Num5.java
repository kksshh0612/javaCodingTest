package Section7;

import java.util.Arrays;
import java.util.Scanner;

// 5. 동전 분배하기
public class Num5 {

    public static int min;

    public static void DFS(int[] coin, int currIdx, int aSum, int bSum, int cSum){     //세명에게 총액 차 가장 작게. 총액은 꼭 다 달라야함.
        if(currIdx == coin.length){
            int[] arr = new int[3];
            if(aSum != bSum && bSum != cSum && aSum != cSum){
                arr[0] = aSum;
                arr[1] = bSum;
                arr[2] = cSum;
                Arrays.sort(arr);               //오름차순 정렬
                if((arr[2] - arr[0]) < min){
                    min = arr[2] - arr[0];      //젤 큰 수와 작은 수의 차
                }
            }
            else return;
        }
        else{
            DFS(coin, currIdx + 1, aSum + coin[currIdx], bSum, cSum);
            DFS(coin, currIdx + 1, aSum, bSum + coin[currIdx], cSum);
            DFS(coin, currIdx + 1, aSum, bSum, cSum + coin[currIdx]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int coinNum = scanner.nextInt();
        int[] coin = new int[coinNum];
        for(int i = 0; i < coinNum; i++){
            coin[i] = scanner.nextInt();
        }
        min = Arrays.stream(coin).sum();

        DFS(coin, 0, 0, 0, 0);

        System.out.println(min);
    }
}
