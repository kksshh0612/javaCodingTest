package Section4;

import java.util.Scanner;

//9. 증가수열 만들기 -> 왼쪽 끝, 오른쪽 끝에서 가져오면서 최장 증가 수열 만들기
public class Num9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        String ansString = "";
        int ans = 0, leftIdx = 0, rightIdx = n-1, max = 0;      //max는 수열에서 현재 가장 큰 수

        while(leftIdx <= rightIdx){
            if(arr[leftIdx] < arr[rightIdx]){       //일단 왼쪽이 오른쪽보다 작을 때
                if(max < arr[leftIdx]){
                    ans++;
                    ansString += 'L';
                    max = arr[leftIdx++];
                }
                else if(max < arr[rightIdx]){
                    ans++;
                    ansString += 'R';
                    max = arr[rightIdx--];
                }
                else{                               //둘다 현재 최대보다 작으면 탈출
                    break;
                }
            }
            else if(arr[leftIdx] > arr[rightIdx]){
                if(max < arr[rightIdx]){
                    ans++;
                    ansString += 'R';
                    max = arr[rightIdx--];
                }
                else if(max < arr[leftIdx]){
                    ans++;
                    ansString += 'L';
                    max = arr[leftIdx++];
                }
                else{                               //둘다 현재 최대보다 작으면 탈출
                    break;
                }
            }
            else{       //수가 같은 경우. 왼쪽 끝으로 생각함.
                if(max < arr[leftIdx]){
                    ans++;
                    ansString += 'L';
                    max = arr[leftIdx++];
                }
                else{
                    break;
                }
            }
        }
        System.out.println(ans);
        System.out.println(ansString);

    }
}
