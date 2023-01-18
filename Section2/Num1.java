package Section2;

import java.util.Scanner;

//1. K번째 약수
public class Num1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int cnt = 0;

        for(int i = 0; i < N ; i++){
            if(N % (i + 1) == 0){
                cnt++;
            }
            if(cnt == K){
                System.out.println(i + 1);
                return;
            }
        }
        System.out.println(-1);
    }


}
