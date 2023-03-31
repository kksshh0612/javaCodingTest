package Section7;

import java.util.Scanner;

// 4. 동전 바꿔주기           --->>>>> 다시 풀어보기 상태트리 중요
public class Num4 {

    public static int cnt;

    public static void DFS(int[] coinType, int[] coinNum, int totalPrice, int currSum, int currIdx){
        if(currSum > totalPrice) return;
        if(currIdx == coinType.length){
            if(currSum == totalPrice){
                cnt++;
            }
        }
        else{
            for(int i = 0; i <= coinNum[currIdx]; i++){          //currIdx를 높이면서 코인당 0~가진갯수만큼 포함시키며 DFS
                DFS(coinType, coinNum, totalPrice, currSum + (coinType[currIdx] * i), currIdx + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalPrice = scanner.nextInt();         //교환할 금액
        int coinTypeNum = scanner.nextInt();        //동전의 종류 수
        int[] coinType = new int[coinTypeNum];      //동전의 종류 담을 배열
        int[] coinNum = new int[coinTypeNum];       //동전 종류 당 동전 몇개 있는지 담을 배열
        for(int i = 0; i < coinTypeNum; i++){
            coinType[i] = scanner.nextInt();
            coinNum[i] = scanner.nextInt();
        }

        DFS(coinType, coinNum, totalPrice, 0, 0);
        System.out.println(cnt);
    }
}
