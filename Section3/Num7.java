package Section3;

import java.util.Scanner;

//7. 사과나무(다이아몬드)
public class Num7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] arr = new int[N][N];
        int sum = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                arr[i][j] = scanner.nextInt();
            }
        }

        int right = 0, left = 0;
        for(int i = 0; i < N; i++){
            if(i < N/2){
                left = N/2 - i;
                right = N/2 + i;
            }
            else{
                left = i - N/2;
                right = N - 1 - left;
            }
            while(left <= right){
                sum += arr[i][left++];
            }
        }
        System.out.println(sum);

    }
}
