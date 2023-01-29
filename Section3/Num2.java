package Section3;

import java.util.Scanner;

//숫자만 추출
public class Num2 {

    public static int common(int n){            //약수의 수 세는 함수
        int cnt = 0;

        for(int i = 0; i < n; i++){         //반 나눠서 그 전까지만 보면 됨.
            if(n % (i + 1) == 0){               //나누어 떨어지면 약수
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();          //입력 문자열

        String inputToInt = input.replaceAll("[^0-9]", "");     //0-9가 아닌 문자들은 공백으로 대체.
        int num = Integer.parseInt(inputToInt);         //숫자로 변환

        int commonNum = common(num);

        System.out.println(num);
        System.out.println(commonNum);

    }
}
