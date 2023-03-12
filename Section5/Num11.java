package Section5;

import java.util.*;

//11. 최대힙
public class Num11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());      //높은 숫자 순으로 우선순위 결정

        while(num != -1){
            if(num == 0){
                if(priorityQueue.isEmpty()){
                    System.out.println(-1);
                }
                else{
                    System.out.println(priorityQueue.poll());
                }
            }
            else{
                priorityQueue.add(num);
            }
            num = scanner.nextInt();
        }
    }
}
