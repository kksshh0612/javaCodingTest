package Section4;

import java.util.Arrays;
import java.util.Scanner;

public class Num1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();      //찾을 수
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = scanner.nextInt();
        }
        int left = 0, right = N - 1, mid = 0;

        Arrays.sort(arr);

        while(arr[mid] != M){
            mid = (left + right) / 2;
            if(M < arr[mid]){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        System.out.println(mid + 1);
    }
}
