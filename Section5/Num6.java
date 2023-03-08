package Section5;

import java.util.*;

//6. 응급실        --> 접수 순서대로. 남은 환자 중에 위험도 높은 환자 있으면 다시 큐 뒤로 넣음.
public class Num6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people = scanner.nextInt();
        int th = scanner.nextInt();         //0번째부터
//        int[] patient = new int[2];         //환자의 처음 인덱스와 위험도 넣는 배열
        Queue<int[]> queue = new LinkedList<>();
        int thRisk = 0, thIdx = 0, ans = 0;        //구하려는 환자의 위험도, 인덱스, 몇번째로 진료받는지

        for(int i = 0; i < people; i++){
            int tmp = scanner.nextInt();
            int[] patient = new int[2];         //환자의 처음 인덱스와 위험도 넣는 배열
            if(i == th){
                thRisk = tmp;               //구하려는 환자의 위험도
                thIdx = i;
            }
            patient[0] = i;
            patient[1] = tmp;
            queue.offer(patient);
        }

        int currRisk = 0;
        while(true){        //반복문 돌면서 얘보다 큰게 있으면 계속 뒤로 보내줌. 일단 한바퀴를 걍 계속 돌아야됨.
            currRisk = queue.peek()[1];        //현재 진료 보려는 환자의 리스크
            for(int i = 0; i < queue.size(); i++){      //큐를 한바퀴 돌리면서 확인
                if(queue.peek()[1] > currRisk){        //리스크가 더 큰 환자 있으면
                    break;
                }
                queue.add(queue.poll());        //현재 환자 맨 뒤로 보냄
            }
            //최대 한바퀴 다 돌았는데 더 위험도 높은 환자 없으면 이 환자 진료
            if(currRisk == queue.peek()[1]){
                if(currRisk == thRisk && queue.peek()[0] == thIdx){         //현재 진료볼 환자가 지정한 환자이면
                    break;
                }
                else{
                    ans++;
                    queue.poll();
                }
            }
        }
        System.out.println(++ans);


    }
}
