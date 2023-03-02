package Section4;

import java.util.Arrays;
import java.util.Scanner;

//8. 침몰하는 타이타닉
public class Num8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int totalWeight = scanner.nextInt();        //보트 한개의 총 무게
        int[] weight = new int[n];
        for(int i = 0; i < n; i++){
            weight[i] = scanner.nextInt();
        }
        int remainWeight = totalWeight, currPeopleCnt = 0, boat = 0, totalPeopleCnt = 0;
        int left = 0, right = n-1;
        Arrays.sort(weight);
        //젤 큰 사람과 젤 작은 사람 함께 태우기
        while(totalPeopleCnt < n){              //모든 사람 다 탈때까지 반복
            boat++;
            if(weight[left] + weight[right] <= totalWeight){
                totalPeopleCnt += 2;
                left++;
                right--;
            }
            else{                       //두명 못타면 현재 젤 무거운 한명만 태움
                totalPeopleCnt++;
                right--;
            }
        }

        System.out.println(boat);
    }
}
