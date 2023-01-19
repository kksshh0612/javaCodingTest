package Section2;

import java.util.Scanner;

//6. 자릿수의 합
public class Num6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];
        int max = 0;
        int maxIdx = 0;
        for(int i = 0;i < N; i++){
            arr[i] = scanner.nextInt();
        }

        for(int i = 0;i < N; i++){
            int num = arr[i];
            int sum = 0;
            while(num > 0){
                sum += num%10;
                num /= 10;
            }

            if(max < sum){
                max = sum;
                maxIdx = i;
            }
        }
        System.out.println(arr[maxIdx]);
    }
}
