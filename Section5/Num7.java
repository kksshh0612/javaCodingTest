package Section5;

import java.util.*;

//7. 교육과정 설계
public class Num7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String order = scanner.next();
        int planNum = scanner.nextInt();
        scanner.nextLine();
        char subject = 0;
        boolean isCorrect = true;                           //설계가 잘 된 수업인지
        Queue<Character> queue= new LinkedList<>();         //우선순위 있는 과목 넣을 큐
        boolean[] alpha = new boolean[26];                  //알파벳(과목)이 우선순위 있는 과목인지 판단하는 배열 -65 해서 사용 인덱스 0부터 A
        for(int i = 0; i < 26; i++){
            alpha[i] = false;
        }

        for(int i = 0; i < planNum; i++){
            String plan = scanner.next();

            for(int t = 0; t < order.length(); t++){
                char token = order.charAt(t);           //하나씩 잘라서
                queue.add(token);                       //큐에 넣음
                alpha[token - 65] = true;               //우선순위가 지정된 수업들을 true로 값을 세팅해줌
            }

            for(int j = 0; j < plan.length(); j++){     //시간표에서 과목 하나씩 탐색
                subject = plan.charAt(j);

                if(!queue.isEmpty()){
                    if(alpha[subject - 65] == true && queue.peek() != subject){        //우선순위 지정된 과목인데 현재 큐 맨 앞에 있는 과목이 아니면
                        isCorrect = false;
                        break;
                    }
                    else if(alpha[subject - 65] == true && queue.peek() == subject){
                        queue.poll();
                        alpha[subject - 65] = false;
                    }
                }
                else{
                    break;          //큐가 비었으면 어떤 수업을 듣든지 상관없음
                }
            }
            for(int j = 0; j < 26; j++){            //필수 과목 중 배치가 안된 과목이 있으면 안됨
                if(alpha[j] == true){
                    isCorrect = false;
                }
            }

            if(isCorrect){
                System.out.println("#" + (i+1) + " YES");
            }
            else{
                System.out.println("#" + (i+1) + " NO");
            }

            isCorrect = true;       //초기화
            queue.clear();
        }
    }
}



