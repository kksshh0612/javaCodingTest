package Section5;

import java.util.Scanner;
import java.util.Stack;

//2. 쇠막대기           ---->           왼쪽 다음 바로 오른쪽 나오면 레이저. 왼쪽 나오면 스택에 넣고, 오른쪽 나오면 스택 peek 확인.
public class Num2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();        //공백까지 문자열 입력
        int pieceCnt = 0;                   //조각의 수
        Stack<Character> stack = new Stack<>();

        boolean isLeft = false;             //이전 탐색한 값이 왼쪽이었는지 확인하는 변수

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '('){               //왼쪽괄호이면 일단 스택에 넣음.
                stack.push('(');
                isLeft = true;
            }
            else if(str.charAt(i) == ')'){          //오른쪽괄호이면 스택 peek를 확인해봐야함.
                if(isLeft){                         //이전이 왼쪽괄호이면 레이저임.
                    stack.pop();                    //레이저 만나면 하나 빼고 현재 스택에 들어있는 왼쪽 괄호 수 다 더함.
                    pieceCnt += stack.size();
                }
                else{                               //이전이 오른쪽 괄호이면 막대기의 끝임.
                    stack.pop();
                    pieceCnt++;
                }
                isLeft = false;
            }
        }

        System.out.println(pieceCnt);
    }
}
