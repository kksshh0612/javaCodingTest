package Section5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//8. 단어 찾기
public class Num8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<String, Boolean> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            String word = scanner.next();
            map.put(word, false);
        }
        for(int i = 0; i < n - 1; i++){
            String word = scanner.next();
            map.put(word, true);            //시에 쓰인 단어는 값을 true로 세팅
        }

        for(String key : map.keySet()){         //키를 탐색하면서
            if(map.get(key).equals(false)){     //value가 false인 단어 찾기
                System.out.println(key);
            }
        }
    }
}
