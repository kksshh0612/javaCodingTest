package Section7;

import java.util.Scanner;

// 6. 알파코드              ---> 좀 이상하긴 한데 다시 풀어보기
public class Num6 {         //1-26 영어 대문자 0은 입력 종료  알파벳 복원 몇글자 결국 부분집합..

    public static int cnt;

    public static void DFS(int[] Code, int[] alphaCode, int codeIdx, int alphaCodeIdx){
        if(codeIdx == Code.length){
            for(int i = 0; i < alphaCode.length; i++){
                if(alphaCode[i] != 0){
                    System.out.print((char)(alphaCode[i] + 64));        //1이 A이기 때문에 64 더함
                }
            }
            System.out.println();
            cnt++;
        }
        else{
            for(int i = 1; i <= 26; i++){        //1~26까지 탐색
                if(i < 10 && Code[codeIdx] == i){
                    alphaCode[alphaCodeIdx] = i;
                    DFS(Code, alphaCode, codeIdx + 1, alphaCodeIdx + 1);
                    alphaCode[alphaCodeIdx] = 0;
                }
                else if(i > 10){        //두자릿수일때
                    if(codeIdx + 1 < Code.length && (Code[codeIdx] == (i / 10) && Code[codeIdx + 1] == (i % 10))){
                        alphaCode[alphaCodeIdx] = i;
                        DFS(Code, alphaCode, codeIdx + 2, alphaCodeIdx + 1);
                        alphaCode[alphaCodeIdx] = 0;
                    }
                }

            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String code = scanner.next();
        int[] arr = new int[code.length()];             //코드를 잘라서 int로 저장
        int[] ans = new int[code.length()];             //복원한 코드를 넣을 배열
        for(int i = 0; i < code.length(); i++){
            if((int)code.charAt(i) - 48 == 0) break;
            arr[i] = (int)code.charAt(i) - 48;
//            System.out.println(arr[i]);
        }

        DFS(arr, ans, 0, 0);

        System.out.println(cnt);
    }
}
