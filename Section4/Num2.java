package Section4;

import java.util.Arrays;
import java.util.Scanner;

public class Num2 {

    private static int count(int[] lanString, int length){
        int cnt = 0;
        int[] lanStringCopy = new int[lanString.length];            //자바에서 매서드의 매개변수에 배열이 들어가면 call by reference임.

        for(int i = 0; i < lanStringCopy.length; i++){              //배열의 복사본 만들기
            lanStringCopy[i] = lanString[i];
        }

        for(int i = 0; i < lanStringCopy.length; i++){
            while(lanStringCopy[i] >= length){
                cnt++;
                lanStringCopy[i] -= length;                 //길이만큼 자르기
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt();
        int N = scanner.nextInt();
        int[] lanString = new int[K];
        int min = 1;
        int max = 0;
        for(int i = 0; i < K; i++){
            lanString[i] = scanner.nextInt();       //랜선 길이 입력력
           if(lanString[i] > max){
                max = lanString[i];                 //랜선 길이 중 최대값 찾음
            }
        }

        int lanCount = 0;
        int length = 0;
        int ans = 0;
        while(min != max){
            length = (min + max) / 2;
            lanCount = count(lanString, length);        //잘린 랜선 수
            if(lanCount < N){                               //잘린 랜선 수가 정해진 수보다 작으면 더 작게 잘라야 함.
                max = length - 1;
            }
            else if(lanCount >= N){                          //잘린 랜선 수가 정해진 수보다 크면 더 크게 잘라도 됨.
                ans = length;                   //일단 정답에 넣어두고
                min = length + 1;               //최소값을 올려줌으로써 좀 더 큰 길이가 있는지 찾음
            }

        }
        System.out.println(ans);
    }
}