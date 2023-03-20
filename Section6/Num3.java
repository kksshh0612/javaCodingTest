package Section6;

import java.util.Scanner;

//3. 부분집합 구하기  -> DFS로 풀기
public class Num3 {

    public static void DFS(int curr, int num, boolean[] arr){
        if(curr == num + 1){
            for(int i = 1; i < arr.length; i++){
                if(arr[i] == true) System.out.print(i + " ");
            }
            System.out.println();
        }else{
            arr[curr] = true;       //현재 숫자 부분집합에 포함.
            DFS(curr + 1, num, arr);
            arr[curr] = false;      //현재 숫자 부분집합에 포함 X
            DFS(curr + 1, num, arr);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        boolean[] arr = new boolean[n+1];       //0번 인텍스 안씀
        DFS(1, n, arr);
    }
}
