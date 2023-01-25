package Section2;

import java.util.Scanner;

//9. 주사위 게임
public class Num9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int maxCost = 0;

        for(int i = 0; i < N; i++){
            int[] arr = new int[3];     //주사위 숫자 넣을 배열
            int cost = 0;
            int maxNumber = 0;
            for(int j  = 0; j < 3; j++){
                arr[j] = scanner.nextInt();
            }
            if(arr[0] == arr[1] && arr[1] == arr[2]){       //세 개 모두 같으면
                cost = 10000 + arr[0] * 1000;
            }
            else{
                if(arr[0] == arr[1]){                       //두 개 같으면
                    cost = 1000 + arr[0] * 100;
                }
                else if(arr[1] == arr[2]){
                    cost = 1000 + arr[1] * 100;
                }
                else if(arr[0] == arr[2]){
                    cost = 1000 + arr[0] * 100;
                }
                else{                                       //세 개 모두 다르면면
                    for(int j  = 0; j < 3; j++){
                        if(maxNumber < arr[j]){
                            maxNumber = arr[j];
                        }
                    }
                    cost = maxNumber * 100;
                }
            }
            if(maxCost < cost){
                maxCost = cost;
            }

        }
        System.out.println(maxCost);
    }
}
