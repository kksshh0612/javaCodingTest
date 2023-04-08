package Section8;

import java.util.Arrays;
import java.util.Scanner;

// 4. 최대 부분 증가 수열
public class Num4_BOTTOMUP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] arr = new int[len];
        for(int i = 0; i < len; i++){
            arr[i] = scanner.nextInt();
        }
        int[] dt = new int[len];        //dynamic table
        dt[0] = 1;

        int idx = 1;
        int ans = 0;
        while(idx < len){
            int max = 0;
            for(int i = idx - 1; i >= 0; i--){
                if(arr[i] < arr[idx] && dt[i] > max){
                    max = dt[i];                        //이전에 있던 값들 중 현재 값보다 작고, 다이나믹 테이블(증가수열 길이)이 최대인 수를 채택.
                }
            }
            dt[idx] = max + 1;
            if(dt[idx] > ans) ans = dt[idx];
            idx++;
        }
        System.out.println(ans);

        //잘못된 알고리즘. 만약 dt가 0 1 3 2 0 0 0 0  일 때,  다섯번째 탐색에서 2에 1을 더하면 3과 같아져서 원래는 3을 가져와야 하는데 그렇게 못함.
        /*boolean check = false;
        while(idx < len){
            check = false;
            for(int i = idx - 1; i >= 0; i--){
                if(arr[i] < arr[idx] && dt[i] > dt[idx]){
                    dt[idx] = dt[i] + 1;
                    check = true;
                }
            }
            if(!check){
                dt[idx] = 1;
            }
            idx++;
        }
        Arrays.sort(dt);
        System.out.println(dt[len - 1]);*/

    }
}
