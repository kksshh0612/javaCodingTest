package Section8;

import java.util.Scanner;

// 3. 돌다리 건너기
public class Num3_BOTTOMUP {                    //0~N+1까지 가는 경우의 수 +1, +2
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int stones = scanner.nextInt();
        int[] caseNum = new int[stones + 2];        //경우의 수 저장할 배열
        caseNum[1] = 1;
        caseNum[2] = 2;

        int idx = 3;
        while (idx <= stones + 1){                  //건너 뛰어야하기 때문에 돌 수보다 하나 더해야됨.
            caseNum[idx] = caseNum[idx - 1] + caseNum[idx - 2];
            idx++;
        }
        System.out.println(caseNum[stones + 1]);
    }
}
