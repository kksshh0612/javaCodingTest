package Section4;

import java.util.Scanner;

// 3. 뮤직비디오  -----> 모든 수를 M개의 바구니에 담을 수 있는 바구니의 최소 크기
public class Num3 {

    public static int check(int[] song, int volume){
        int[] songCopy = new int[song.length];
        int bundle = 1, sum = 0;         //묶음 수, 묶음 당 합계
        for(int i = 0; i < songCopy.length; i++){
            songCopy[i] = song[i];
        }

        for(int i = 0; i < songCopy.length; i++){
            if(sum + songCopy[i] > volume){             //이번에 더할 값이 묶음당 용량을 넘으면
                bundle++;                       //묶음 수 증가
                sum = songCopy[i];              //넘은 수 더해서 다음으로 넘김
            }
            else{
                sum += songCopy[i];
            }
        }

        return bundle;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] song = new int[N];
        int min = 1, max = 0, mid = 0, maxx = 0;
        int ans = 0;
        for(int i = 0; i < N; i++){
            song[i] = scanner.nextInt();
            max += song[i];
            if(maxx < song[i]){
                maxx = song[i];         //최대값 찾기
            }
        }

        //최소와 최대 사이에서 N개의 곡을 M개의 바구니에 담을 수 있는 바구니의 최소 크기 구하기
        while(min <= max){
            mid = (min + max) / 2;      //바구니의 크기가 될 수 있는 수

            int bundle = check(song, mid);           //해당 크기의 바구니로 노래를 담을 때 생기는 묶음 수

            if(mid >= maxx && bundle <= M){     //묶음 수가 M보다 작다면 바구니 용량을 줄여야함. 같아도 용량을 줄일 수 있으면 줄임.
                max = mid - 1;
                ans = mid;
            }
            else{                //묶음 수가 M보다 크다면 바구니 용량을 키워야 함.
                min = mid + 1;
            }
        }

        System.out.println(ans);
    }
}
