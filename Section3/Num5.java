package Section3;

import java.util.Scanner;

//5. 수들의 합
public class Num5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        int indexL = 0;
        int indexR = 1;
        int sum = 0, cnt = 0;

        while(indexL < n){      //왼쪽이 마지막에 다다를 때까지 반복
            sum = arr[indexL];
            indexR = indexL + 1;

            while(sum < m && indexR < n){
                sum += arr[indexR++];
            }
            if(sum == m){
                cnt++;
            }
            indexL++;
        }
        System.out.println(cnt);
    }
}
