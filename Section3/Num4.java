package Section3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//두 리스트 합치기
public class Num4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int N1 =  scanner.nextInt();
        for(int i = 0; i < N1; i++){
            list.add(scanner.nextInt());
        }
        int N2 =  scanner.nextInt();
        for(int i = 0; i < N2; i++){
            list.add(scanner.nextInt());
        }
        Collections.sort(list);
        for(int i = 0; i < N1 + N2; i ++){
            System.out.print(list.get(i) + " ");
        }


    }
}
