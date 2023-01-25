package Section2;

import java.util.Scanner;

//8. 뒤집은 소수
public class Num8 {
    static int reverse(int x){
        int reverseNum = 0;
        int[] arr = new int[6];
        int cnt = 0;
        while(x > 0){
            arr[cnt] = x%10;        //맨 끝 자리부터 배열에 들어감
            x /= 10;
            cnt++;          //자릿수
        }
        for(int i = 0; i < cnt; i++){
            reverseNum += arr[i] * Math.pow(10, (cnt - i -1));
        }
        return reverseNum;
    }

    public static boolean isPrime(int x){
        int[] arr = new int[x+1];
        for(int i = 0; i < x+1; i++){
            arr[i] = 0;
        }
        for(int i = 2; i <= x; i++){
            if(arr[i] == 0){
                for(int j = i + i; j <= x; j += i){
                    arr[j]++;
                }
            }
        }
        if(arr[x] == 0){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for(int i = 0; i < N; i++){
            int num = scanner.nextInt();
            int reverseNum = reverse(num);              //수를 뒤집는 함수
            boolean isPrimenum = isPrime(reverseNum);   //소수인지 판별하는 함수
            if(isPrimenum){     //소수이면 뒤집은 수 출력
                System.out.println(reverseNum);
            }
        }
    }
}
