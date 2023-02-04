package Section3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//4. 두 리스트 합치기
public class Num4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> ansList = new ArrayList<>();

        int N1 =  scanner.nextInt();
        for(int i = 0; i < N1; i++){
            list1.add(scanner.nextInt());
        }
        int N2 =  scanner.nextInt();
        for(int i = 0; i < N2; i++){
            list2.add(scanner.nextInt());
        }

        int indexFisrt = 0, indexSecond = 0;
        while(indexFisrt < N1 && indexSecond < N2){     //둘 중 하나라도 리스트 끝에 다다르면 탈출
            if(list1.get(indexFisrt) < list2.get(indexSecond)){
                ansList.add(list1.get(indexFisrt));
                indexFisrt++;
            }
            else{
                ansList.add(list2.get(indexSecond));
                indexSecond++;
            }
        }

        while(indexFisrt < N1){
            ansList.add(list1.get(indexFisrt++));
        }
        while(indexSecond < N2){
            ansList.add(list2.get(indexSecond++));
        }
        for(int i = 0; i < ansList.size(); i++){
            System.out.print(ansList.get(i) + " ");
        }
    }
}
