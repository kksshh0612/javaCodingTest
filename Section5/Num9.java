package Section5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//9. 아나그램
public class Num9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();
        boolean isAnagram = true;
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < str1.length(); i++){
            char token = str1.charAt(i);
            if(map.get(token) == null){
                map.put(token, 1);
            }
            else{
                map.put(token, map.get(token) + 1);
            }
        }

        for(int i = 0; i < str2.length(); i++){
            char token = str2.charAt(i);
            if(map.get(token) == null || map.get(token) == 0){
                isAnagram = false;
                break;
            }
            else{
                map.put(token, map.get(token) - 1);
            }
        }
        if(isAnagram) System.out.println("YES");
        else System.out.println("NO");
    }
}
