package Section5;

import java.util.PriorityQueue;
import java.util.Scanner;

//10. 최소 힙
public class Num10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();       //낮은 수 우선으로
        while(num != -1){
            if(num == 0){
                if(priorityQueue.isEmpty()){        //우선순위 큐가 비어있으면
                    System.out.println(-1);
                }
                else{
                    System.out.println(priorityQueue.poll());
                }
            }
            else {
                priorityQueue.add(num);
            }
            num = scanner.nextInt();
        }
    }
}
