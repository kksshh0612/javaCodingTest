package Section3;

import java.util.Scanner;

//9. 봉우리
public class Num9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dirX = {0,1,0,-1};        //북동남서
        int[] dirY = {-1,0,1,0};        //북동남서
        int cnt = 0;                    //봉우리 수
        boolean check = false;          //주변에 나보다 큰게 있는지 확인하는 변수 true이면 큰 수가 있는거임.

        int N = scanner.nextInt();
        int[][] arr = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                arr[i][j] = scanner.nextInt();      //입력
            }
        }

        int x = 0, y = 0;               //현재 인덱스
        while(y < N){          // 0,0 에서 시작해서 N-1,N-1로 가는데 한 행씩 검사. 근데 해당 행이 봉우리이면 바로 옆은 건너뀜.
            while(x < N){
                check = false;      //초기화
                for(int i = 0; i < 4; i++){
                    int idxY = y + dirY[i];         //탐색할 Y좌표
                    int idxX = x + dirX[i];         //탐색할 X좌표
                    if((idxY > -1 && idxY < N) && (idxX > -1 && idxX < N)){         //배열을 벗어나지 않을 때
                        if(arr[idxY][idxX] >= arr[y][x]){                            //주변에 나보다 크거나 같은 수가 있으면
                            check = true;
                            break;              //나머지는 확인할 필요 없음. 이미 봉우리가 아닌 것이 확인됐기 때문
                        }
                    }
                }
                if(check == true){      //현재 위치가 봉우리가 아니면
                    x++;
                }
                else{                   //현재 위치가 봉우리이면
                    cnt++;
                    x += 2;             //옆에 수는 확인할 필요 없음. 하나 건너뜀
                }
            }
            //x가 배열의 범위 벗어나면
            x = 0;
            y++;                //다음 행으로 이동
        }

        System.out.println(cnt);
    }
}
