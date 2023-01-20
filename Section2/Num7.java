package Section2;

import java.util.Scanner;

//7. 소수(에라토스테네스의 체)
public class Num7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        boolean[] arr = new boolean[N+1];   //1~N까지 인덱스 사용
        int cnt = 0;

        for(int i = 2; i <= N; i++){
            if(arr[i] != true){
                cnt++;
                for(int j = i; j <= N; j += i){
                    arr[j] = true;
                }
            }
        }
        System.out.println(cnt);
    }
}
