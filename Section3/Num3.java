package Section3;

import java.util.Scanner;

//카드 역배치
public class Num3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] card = new int[21];
        for(int i = 1; i < 21; i++){
            card[i] = i;
        }

        for(int i = 0; i < 10; i ++){
            int start = scanner.nextInt();
            int end = scanner.nextInt();

            int loopEnd = (int)(((double)end + 1 - (double)start) / 2 + 0.5);       //반만 반복하면 됨.

            for(int j = 0; j < loopEnd; j++){          //start부터 end까지 뒤집기
                int tmp = card[start + j];
                card[start + j] = card[end - j];
                card[end - j] = tmp;
            }
        }

        for(int i = 1; i < card.length; i++){
            System.out.print(card[i] + " ");
        }
    }
}
