package Section8;

import java.util.Scanner;

// 5. 최대 선 연결하기 (바텀업)
public class Num5_BOTTOMUP {                    //최장증가부분수열과 같음.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();              //전체 수열 길이
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        int[] dt = new int[n];
        dt[0] = 1;
        int ans = 0, idx = 1;

        while(idx < n){
            int max = 0;
            for(int i = idx - 1; i >= 0; i--){
                if(arr[i] < arr[idx] && dt[i] > max){
                    max = dt[i];
                }
            }
            dt[idx] = max + 1;
            if(dt[idx] > ans){
                ans = dt[idx];
            }
            idx++;
        }
        System.out.println(ans);
    }
}
