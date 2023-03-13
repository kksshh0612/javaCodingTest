package Section6;

import java.util.Scanner;
import java.util.Stack;

//1. 재귀함수를 이용한 이진수 출력
public class Num1 {
    //스택 사용
    public static String Convert(int n){
        String returnVal = "";
        Stack<Integer> stack = new Stack<>();
        while(n > 1){
            stack.push(n % 2);
            n /= 2;
        }
        stack.push(1);
        while(!stack.empty()){
            returnVal += Integer.toString(stack.peek());
            stack.pop();
        }
        return returnVal;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int decimalNumber = scanner.nextInt();
        String ans = Convert(decimalNumber);

        System.out.println(ans);
    }
}
