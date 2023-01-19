package Section2;

import java.util.Scanner;

//4. 대표값
public class Num4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] student = new int[N];
        double sum = 0;
        int avg = 0;
        int minDiff = 0;    //차이의 최소값
        int minDiffIdx = 0; //차이의 최소값인 수의 인덱스
        int diff = 0;

        for(int i = 0; i < N; i++){
            student[i] = scanner.nextInt();
            sum += student[i];
        }

        avg = (int)((sum / N) + 0.5);       //평균
        minDiff = avg + 1;                  //초기값 설정. 평균과의 차이기 때문에 평균보다 클 수 없다.

        //같으면 양수. 같으면서 양수이면 인덱스 빠른순.
        for(int i = 0; i < N; i++){
            diff = student[i] - avg;
            if(Math.abs(diff) < minDiff){
                minDiff = Math.abs(diff);
                minDiffIdx = i;
            }
            else if(Math.abs(diff) == minDiff && diff > 0){     //같으면서 현재 것이 음수이면 이전에 넣은 값이 양수인지 확인해야 한다.
                if(student[minDiffIdx] - avg < 0){              //이전 값이 음수이면 교체. 이전 값이 양수이거나 0이면 이전 값 그대로 둠.
                    minDiff = Math.abs(diff);
                    minDiffIdx = i;
                }
            }
        }

        System.out.println(avg + " " + (minDiffIdx + 1));
    }
}
