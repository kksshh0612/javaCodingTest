package Section6;

import java.util.Scanner;

//5. 바둑이 승차 -> 이것도 부분집합이네 결국
public class Num5 {

    public static int maxWeight;

    public static void DFS(int[] dogWeight, boolean[] checkArr, int trukWeight, int dogNum, int currIdx){
        if(currIdx == dogNum){
            int sum = 0;
            for(int i = 0; i < dogNum; i++){
                if(checkArr[i] == true){
                    sum += dogWeight[i];
                }
            }
            if(sum < trukWeight && maxWeight < sum) {
                maxWeight = sum;
            }
        }
        else{
            checkArr[currIdx] = true;
            DFS(dogWeight, checkArr, trukWeight, dogNum, currIdx + 1);
            checkArr[currIdx] = false;
            DFS(dogWeight, checkArr, trukWeight, dogNum, currIdx + 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int trukWeight = scanner.nextInt();
        int dogNum = scanner.nextInt();
        int[] dogWeight = new int[dogNum];
        for(int i = 0; i < dogNum; i++){
            dogWeight[i] = scanner.nextInt();
        }
        boolean[] checkArr = new boolean[dogNum];
        maxWeight = 0;

        DFS(dogWeight, checkArr, trukWeight, dogNum, 0);

        System.out.println(maxWeight);
    }
}
