package Section4;

import java.util.Arrays;
import java.util.Scanner;

public class Num7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int L = scanner.nextInt();      //가로 길이
        int[] arr = new int[L];
        for(int i = 0; i < L; i++){
            arr[i] = scanner.nextInt();
        }
        int M = scanner.nextInt();      //옮기는 횟수

        for(int i = 0; i < M; i++){
            Arrays.sort(arr);               //오름차순 정렬
            arr[0]++;
            arr[L-1]--;
        }
        Arrays.sort(arr);               //오름차순 정렬
        System.out.println(arr[L-1] - arr[0]);
    }
}
