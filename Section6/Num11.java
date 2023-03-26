package Section6;

import java.util.Scanner;

// 11. 수들의 조합       ->>>>>>>>>>>>>>>>>>> 다시 한번 풀어보기
public class Num11 {

    public static int cnt;

    public static void DFS(int[] arr, int partialNum, int[] currCombination, int currIdx, int combIdx, int multiple){
        if(combIdx == partialNum){
            int sum = 0;
            for(int i = 0; i < currCombination.length; i++){
                sum += currCombination[i];
//                System.out.print(currCombination[i] + " ");
            }
            if(sum % multiple == 0){
                cnt++;
            }
//            System.out.println();
        }
        else{
            for(int i = currIdx; i < arr.length; i++){
                currCombination[combIdx] = arr[i];
//                System.out.println("i = " + i + " currIdx = " + currIdx + " currNum = " + arr[i]);
                DFS(arr, partialNum, currCombination, i + 1, combIdx + 1, multiple);
//                System.out.println(" currIdx = " + currIdx);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalNum = scanner.nextInt();           //전체 몇 개
        int partialNum = scanner.nextInt();         //몇개 뽑을지
        int[] arr = new int[totalNum];
        for(int i = 0; i < arr.length; i++){
            arr[i] = scanner.nextInt();
        }
        int multiple = scanner.nextInt();           //몇의 배수인지
        cnt = 0;

        int[] currCombination = new int[partialNum];

        DFS(arr, partialNum, currCombination, 0, 0, multiple);
        System.out.println(cnt);
    }
}
