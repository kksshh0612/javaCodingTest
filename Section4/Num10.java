package Section4;

import java.util.Scanner;

//10. 역수열
public class Num10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        int[] ansArr = new int[n];          //정답 배열

        ansArr[arr[0]] = 1;                 //1보다 작은 수는 없기 때문에 그냥 역수열 첫번째 수를 인덱스로 넣으면 됨.

        //1부터 확인하면서 배치하기. 자신보다 큰 수 - 자신보다 작은 수 중에 앞에 있는 수의 수
        for(int i = 1; i < arr.length; i++){        //2부터 탐색
            int currNum = i + 1;
            int cntBig = 0, cntSmall = 0, idx = 0;       //나보다 큰 것의 수
            while(cntBig <= arr[i]){
                if(ansArr[idx] != 0 && ansArr[idx] < currNum) {
                    cntSmall++;
                }
                else{
                    cntBig++;
                }
                idx++;
            }
            ansArr[arr[i] + cntSmall] = currNum;

        }

        for(int i = 0; i < ansArr.length; i++){
            System.out.print(ansArr[i] + " ");
        }
    }
}
