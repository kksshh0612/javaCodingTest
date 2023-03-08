package Section5;

import java.util.Scanner;
import java.util.Stack;

//4. 후위식 연산
public class Num4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.next();
        int ans = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < expression.length(); i++){       //식을 하나씩 잘라서 탐색
            char token = expression.charAt(i);
            if(Character.isDigit(token)){                   //만약 숫자이면
                stack.push(Integer.parseInt(Character.toString(token)));    //스택에 push
            }
            else{                                           //숫자가 아니면
                int second = stack.pop();
                int first = stack.pop();
                switch (token){
                    case '+':
                        stack.push(first + second);
                        break;
                    case  '-':
                        stack.push(first - second);
                        break;
                    case '*':
                        stack.push(first * second);
                        break;
                    case '/':
                        stack.push(first / second);
                        break;
                }
            }
        }
        System.out.println(stack.peek());
    }
}
