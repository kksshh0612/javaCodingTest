package Section2;

import java.util.*;

//3. K번째 큰 수
public class Num3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] arr = new int[N];
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < N; i++){
            arr[i] = scanner.nextInt();
        }

        for(int i = 0; i < N-2; i++){
            for(int j = i+1; j < N-1; j++){
                for(int h = j+1; h < N; h++){
                    set.add(arr[i] + arr[j] + arr[h]);
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>(set);       //set을 list로 변환
        result.sort(Comparator.reverseOrder());                  //내림차순 정렬

        System.out.println(result.get(K-1));
    }
}
