package Section6;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//7. 동전교환
public class Num7 {

    public static int min;

    public static void DFS(Integer[] coin, int coinCnt, int price, int priceSum){
        if(coinCnt > min) return;       //동전 수 최소보다 많아지면 탐색할 필요 없음.
        if(priceSum == price){
            if(coinCnt < min){
                min = coinCnt;
            }
        }
        else if(priceSum > price){      //금액을 넘어가면 안됨
            return;
        }
        else{
            for(int i = 0; i < coin.length; i++){
//                priceSum += coin[i];                  //값 변경하지 않기!! 중요..
//                System.out.println(coin[i]);
                DFS(coin, coinCnt + 1, price, priceSum + coin[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int typeNum = scanner.nextInt();        //코인 종류
        int[] coin = new int[typeNum];
        for(int i = 0; i < typeNum; i++){
            coin[i] = scanner.nextInt();
        }
        int price = scanner.nextInt();
        min = 500;

        Integer[] coinCopy = Arrays.stream(coin).boxed().toArray(Integer[]::new);
        Arrays.sort(coinCopy, Collections.reverseOrder());      //내림차순 정렬

        DFS(coinCopy, 0, price, 0);


        System.out.println(min);

    }
}
