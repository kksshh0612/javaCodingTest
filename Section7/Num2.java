package Section7;

import java.util.Scanner;

public class Num2 {

    public static int maxReward;

    public static void DFS(int[] days, int[] rewards, int currIdx, int totalDays, boolean[] check){
        if(currIdx > totalDays){
            return;
        }
        if(currIdx == totalDays){
            int sum = 0;
            for(int i = 0; i < totalDays; i++){
                if(check[i]){
                    sum += rewards[i];
                }
            }
            if(sum > maxReward) maxReward = sum;
        }
        else{
            for(int i = currIdx; i < totalDays; i++){
                check[i] = true;
                DFS(days, rewards, i + days[i], totalDays, check);
                check[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalDays = scanner.nextInt();
        int[] days = new int[totalDays];
        int[] rewards = new int[totalDays];
        for(int i = 0; i < totalDays; i++){
            days[i] = scanner.nextInt();
            rewards[i] = scanner.nextInt();
        }
        boolean[] check = new boolean[totalDays];

        maxReward = 0;

        DFS(days, rewards, 0, totalDays, check);

        System.out.println(maxReward);
    }
}
