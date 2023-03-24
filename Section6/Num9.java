package Section6;

import java.util.Scanner;
import java.util.concurrent.LinkedTransferQueue;

// 9. 수열 추측하기
public class Num9 {

    public static int[] ansArr, biCoef;         //정답 배열, 이항계수
    public static boolean alreadyAnsExist;

    public static void DFS(int num, int topNum, int currIdx, int[] check, boolean[] isContained){     // 1 ~ topNum까지 두개씩 부분집합을 만들면서
        if(alreadyAnsExist == true) return;

        if(currIdx == topNum){          //숫자를 모두 뽑으면
            int sum = 0;
            for(int i = 0; i < check.length; i++){
                sum += check[i] * biCoef[i];
            }
            if(sum == num){
                for(int i = 0; i < check.length; i++){
                    ansArr[i] = check[i];
                }
                alreadyAnsExist = true;
            }

        }
        else{
            for(int i = 0; i < topNum; i++){
                if(isContained[i + 1] == false){        //이미 포함된 수면 넣으면 안됨.
                    isContained[i + 1] = true;
                    check[currIdx] = i + 1;
                    DFS(num, topNum, currIdx + 1, check, isContained);
                    isContained[i + 1] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int topNum = scanner.nextInt();             //맨 위에 숫자가 몇개인지
        int bottom = scanner.nextInt();             //가장 아래에 있는 수
        int[] check = new int[topNum];
        boolean[] isContained = new boolean[topNum + 1];
        ansArr = new int[topNum];
        biCoef = new int[topNum];       //이항 계수 저장할 배열
        biCoef[0] = 1;
        for(int i = 1; i < topNum; i++){                        //이 부분은 나중에 따로 정리하기
            biCoef[i] = biCoef[i - 1] * (topNum - i) / i;
        }
        alreadyAnsExist = false;
        for(int i = 0; i < isContained.length; i++){
            isContained[i] = false;
        }

        DFS(bottom, topNum, 0, check, isContained);
        for(int i = 0; i < ansArr.length; i++){
            System.out.print(ansArr[i] + " ");
        }

    }
}
