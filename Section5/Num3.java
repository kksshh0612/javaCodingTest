package Section5;


import java.util.*;

//3. 후위표기식 만들기      -> 스택 탑에 나보다 우선순위 높거나 같은거 있으면 pop, 왼쪽 괄호 나오면 push, 오른쪽 괄호 나오면 왼쪽 괄호 나올때까지 pop
public class Num3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.next();
        Stack<Character> stack = new Stack<>();
        Map<Character, Integer> map = new HashMap<>();      //우선순위 지정
        map.put('(', 3);
        map.put('+', 2);
        map.put('-', 2);
        map.put('*', 1);
        map.put('/', 1);
        String ans = "";

        for(int i = 0; i < expression.length(); i++){       //수식을 한 글자씩 잘라서 탐색
            char token = expression.charAt(i);              //한 글자씩 자름

            if(Character.isDigit(token)){                   //숫자이면
                ans += Character.toString(token);
            }
            else{       //문자이면
                if(stack.empty()){      //스택이 비었으면 그냥 push
                    stack.push(token);
                }
                else{                   //스택이 비어있지 않을 때
                    switch (token){
                        case '(': stack.push(token);       //왼쪽괄호이면 일단 push
                            break;
                        case ')':
                            while(stack.peek() != '('){      //왼쪽 괄호가 나올 때까지 pop
                                ans += Character.toString(stack.peek());
                                stack.pop();
                            }
                            stack.pop();        //왼쪽 괄호 빼줌
                            break;
                        default:                // +, -, / *
                            while(!stack.empty() && map.get(stack.peek()) <= map.get(token)){
                                ans += Character.toString(stack.peek());
                                stack.pop();
                            }
                            stack.push(token);
                    }
                }
            }
        }
        while(!stack.empty()){          //스택에 남아있는 연산자 모두 빼기
            ans += Character.toString(stack.peek());
            stack.pop();
        }
        System.out.println(ans);
    }
}


