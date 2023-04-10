package Section8;

import java.util.Scanner;

// 8. 가방문제 (냅색 알고리즘)            ---->>> 매우 중요!!!!!!!
public class Num8_BOTTOMUP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int jewelNum = scanner.nextInt();       //보석 종류
        int totalWeight = scanner.nextInt();    //가방에 들어갈 최대 무게
        int[][] jewel = new int[jewelNum][2];   //보석 무게와 가치
        for(int i = 0; i < jewelNum; i++){
            jewel[i][0] = scanner.nextInt();    //무게
            jewel[i][1] = scanner.nextInt();    //가치
        }
        int[] dt = new int[totalWeight + 1];    //각 인덱스는 해당 무게가 최대 무게일 때, 담을 수 있는 최대 가치
        dt[0] = 0;

        int currWeight = 0, currVal = 0;
        for(int i = 0; i < jewelNum; i++){
            currWeight = jewel[i][0];       //현재 추가할 보석의 무게
            currVal = jewel[i][1];          //현재 추가할 보석의 가치
            for(int j = currWeight; j <= totalWeight; j++){
                if(dt[j - currWeight] + currVal > dt[j]){
                    dt[j] = dt[j - currWeight] + currVal;
                }
            }
        }
        System.out.println(dt[totalWeight]);
    }
}
