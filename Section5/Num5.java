package Section5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//5. 공주 구하기         ---> 해당 번째 번호 빠지고, 그 다음부터 다시 번째 셈. 빼고 뒤로 다시 넣으면 됨.
public class Num5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        int th = scanner.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        int callCnt = 0;        //불러서 빠진 왕자 수

        for(int i = 0; i < total; i++){
            queue.add(i + 1);           //1~8까지 수 삽입
        }

        while(callCnt < total){     //7명까지 뺐으면 끝. 8번째는 출력해야됨.
            for(int i = 0; i < th - 1; i++){        //몇 번째 직전까지 반복
                int tmp = queue.poll();
                queue.add(tmp);                 //맨 앞 수 빼고 맨 뒤로 넣음
            }
            if(callCnt == total - 1){
                System.out.println(queue.poll());
            }
            else{
                queue.poll();       //몇 번째 수 뺌
            }
            callCnt++;
        }

    }
}
