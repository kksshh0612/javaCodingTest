package Section4;

import javax.naming.PartialResultException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.Callable;

// 4. 마구간 정하기  ----> 마구간 위치를 정렬한 후, C개를 뽑는데, 가장 가까운 거리의 값이 최대가 되도록 함.
public class Num4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();      //마구간 수
        int C = scanner.nextInt();      //말 수
        int[] houseLoc = new int[N];    //마구간 위치
        for(int i = 0; i < N; i++){
            houseLoc[i] = scanner.nextInt();
        }
        Arrays.sort(houseLoc);          //마구간 위치 정렬

        //houseLoc에서 C개를 뽑아서, 거리의 최솟값을 구하고, 그 값의 최대값을 찾는다.
        //모든 말의 거리가 최소값보다 커야 하므로, 이분탐색으로 최소값을 찾고, 그만큼보타 띄어서 말을 배치할 수 있는지 확인한다.
        int shortestDistance = 0;       //거리의 최솟값. 이 값이 최대가 되는 것을 찾으면 됨.
        int distanceMin = 1, distanceMax = houseLoc[houseLoc.length - 1] - houseLoc[0], distanceMid = (distanceMin + distanceMax) / 2;
        int cnt = 1;        //배치된 말의 수. 첫번째 말은 무조건 맨 앞에 배치
        int preLocIdx = 0;     //직전 말이 배치된 위치. 인덱스

        // 1 2 4 8 9
        while(distanceMin <= distanceMax){
            distanceMid = (distanceMin + distanceMax) / 2; //2
            cnt = 1;
            preLocIdx = 0;

            for(int i = preLocIdx + 1; i < N; i++){         //일단 끝까지 가보면서 말을 정해진 거리보다 멀게 배치해봄.
                if(houseLoc[i] - houseLoc[preLocIdx] >= distanceMid){
                    preLocIdx = i;      //위치 저장
                    cnt++;              //말 배치
                }
            }
            //끝까지 갔는데 말 다 배치 못했으면
            if(cnt < C){
                distanceMax = distanceMid - 1;
            }
            else if(cnt >= C){                 //배치 하고도 뒤에 마구간이 남았으면
                shortestDistance = distanceMid;                     //일단 정답 저장
                distanceMin = distanceMid + 1;
            }
        }
        System.out.println(shortestDistance);
    }
}
