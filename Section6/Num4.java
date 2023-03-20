package Section6;

import java.util.Scanner;

//4. 합이 같은 부분집합 -> 두 개의 부분집합으로 나누었을 때, 원소의 합이 같은 경우 존재하면 YES
public class Num4 {

    static boolean isExist;

    public static void DFS(int[] arr, boolean[] checkArr, int currIdx, int endIdx){      //checkArr은 부분집합에 포함되는지 아닌지 표시하는 배열
        if(currIdx == endIdx){
            int trueSum = 0, falseSum = 0;
            for(int i = 0; i < checkArr.length; i++){
                if(checkArr[i] == true){
                    trueSum += arr[i];         //현재 부분집합의 값들 모두 더함
                }
                else{
                    falseSum += arr[i];         //다른 부분집합의 값들 모두 더함
                }
            }
            if(trueSum == falseSum) isExist = true;     //부분집합의 합이 전체 합의 반이면 true
        }
        else{
            checkArr[currIdx] = true;
            DFS(arr, checkArr, currIdx + 1, endIdx);
            checkArr[currIdx] = false;
            DFS(arr, checkArr, currIdx + 1, endIdx);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
            sum += arr[i];
        }
        isExist = false;
        boolean[] checkArr = new boolean[n];            //해당 인덱스의 배열 value를 부분집합에 포함하는지 아닌지 표시

        DFS(arr, checkArr, 0, n);

        if(isExist) System.out.println("YES");
        else System.out.println("NO");
    }
}
