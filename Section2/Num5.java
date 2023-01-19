package Section2;

import java.util.Scanner;

//5. 정다면체
public class Num5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] sum = new int[N+M+1];     //인덱스 1부터 사용
        int max = 0;

        for(int i = 1; i <= N; i++){        //주사위 숫자 합
            for(int j = 1; j <= M; j++){
                sum[i+j]++;
            }
        }

        for(int i = 1; i < N+M+1; i++){     //최댓값
            if(max <= sum[i]){
                max = sum[i];
            }
        }
        for(int i = 1; i < N+M+1; i++){
            if(max == sum[i]){
                System.out.print(i + " ");
            }
        }
    }
}
