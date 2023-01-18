package Section2;

import java.util.Arrays;
import java.util.Scanner;

//2. K번째 수
public class Num2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for(int i = 0; i < T; i++){
            int N = scanner.nextInt();
            int s = scanner.nextInt();
            int e = scanner.nextInt();
            int k = scanner.nextInt();
            int[] arr = new int[N];

            for(int j = 0; j < N; j++){     //배열 입력
                arr[j] = scanner.nextInt();
            }
            arr = Arrays.copyOfRange(arr, s-1, e);      //인덱스 s-1부터 e 전까지 슬라이싱

            Arrays.sort(arr);       //정렬
            System.out.println("#" + (i+1) + " " + arr[k-1]);

        }
    }
}
