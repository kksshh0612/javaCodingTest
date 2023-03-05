package Section5;

import java.util.*;

//1. 가장 큰 수
public class Num1 {                 //수에서, 앞이 클 수록 큰 수이기 때문에, 앞부터 확인하면서 나보다 큰 수들은 제거해나가는 알고리즘
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputNum = scanner.next();           //수를 문자열로 입력받음
        int m = scanner.nextInt();                      //뺄 숫자의 수
        Stack<Integer> stack = new Stack<>();
        String ans = "";

//        for(int i = 0; i < inputNum.length(); i++){     //잘라서 스택에 넣기.
//            int n = Integer.parseInt(Character.toString(inputNum.charAt(i)));   //잘라서 character형으로 만들고 string으로 변환
//            stack.push(n);
//        }
        stack.push(Integer.parseInt(Character.toString(inputNum.charAt(0))));       //첫번째 수는 일단 넣음

        int delCnt = 0;        //두번째 수부터 탐색
        for(int i = 1; i < inputNum.length(); i++){              //수와 큐를 비교하며 진행
            int curr = Integer.parseInt(Character.toString(inputNum.charAt(i)));    //현재 탐색중인 수

            if(delCnt < m){
                while(!stack.empty() && stack.peek() < curr){         //스택 최 상단 값. 즉, 직전에 스택에 넣은 값이 현재 수보다 작으면 pop
                    if(delCnt >= m) break;
                    delCnt++;
                    stack.pop();
                }
            }
            stack.push(curr);
        }
        while (delCnt++ < m) {      //제거가 모두 끝나지 않은 상태로 반복문 종료하면
            stack.pop();
        }

        int size = stack.size();
        for(int i = 0; i < size; i++){      //스택에 들어있는 원소 수만큼 반복
             ans = stack.peek() + ans;
             stack.pop();
        }
        System.out.println(ans);
    }
}
