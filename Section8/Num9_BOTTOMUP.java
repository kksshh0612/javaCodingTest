package Section8;

import java.util.Scanner;

// 9. 동전교환
public class Num9_BOTTOMUP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int coinTypeNum = scanner.nextInt();            //동전 종류 수
        int[] coinType = new int[coinTypeNum];          //동전 종류
        for(int i = 0; i < coinTypeNum; i++){
            coinType[i] = scanner.nextInt();
        }
        int total = scanner.nextInt();                  //동전 총 합
        int[] dt = new int[total + 1];      //각 인덱스는 그 만큼이 total일 때 거슬러받는 최소 동전 갯수
        dt[0] = 0;

        for(int i = 0; i < coinTypeNum; i++){
            for(int j = coinType[i]; j <= total; j++){
                if(dt[j] != 0){
                    if(dt[j - coinType[i]] + 1 < dt[j]){
                        dt[j] = dt[j - coinType[i]] + 1;
                    }
                }
                else{       //최소 동전 수가 0이면 일단 넣음.
                    dt[j] = dt[j - coinType[i]] + 1;
                }
            }
        }
        System.out.println(dt[total]);
    }
}
