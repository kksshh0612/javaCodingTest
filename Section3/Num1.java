package Section3;

import java.util.Locale;
import java.util.Scanner;

//회문 문자열 검사
public class Num1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();             //nextInt() 후 엔터가 버퍼에 남아있어,  scanner.nextLine();을 해줌으로써 버퍼에 있던 엔터를 입력받아 없애버림
        for(int i = 0; i < N; i++){
            String inputStr = scanner.nextLine();           //문자열 입력
            inputStr = inputStr.toLowerCase(Locale.ROOT);   //소문자로 변환
            StringBuffer stringBuffer = new StringBuffer(inputStr);     //문자열 뒤집음.
            String reverseStr = stringBuffer.reverse().toString();      //뒤집힌 문자열

            if(inputStr.equals(reverseStr)){
                System.out.println("#" + (i + 1) + " YES");
            }
            else{
                System.out.println("#" + (i + 1) + " NO");
            }
        }
    }
}
