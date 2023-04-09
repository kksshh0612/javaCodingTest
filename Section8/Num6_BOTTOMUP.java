package Section8;

import java.util.*;

// 6번 가장 높은 탑 쌓기     -->>>>> 다시 풀어보기
public class Num6_BOTTOMUP {    //무게 무겁고 넓이 큰 상자가 밑으로.

    public static class Block {
        int areaSize, height, weight;

        Block(int areaSize, int height, int weight){
            this.areaSize = areaSize;
            this.height = height;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Block> blocks = new ArrayList<>();     //블록의 객체 리스트
        int areaSize, height, weight;

        for(int i = 0; i < n; i++){
            areaSize = scanner.nextInt();
            height = scanner.nextInt();
            weight = scanner.nextInt();
            blocks.add(new Block(areaSize, height, weight));        //객체 리스트에 추가
        }

        Comparator<Block> comparator = new Comparator<Block>() {
            @Override
            public int compare(Block o1, Block o2) {
                return o2.areaSize - o1.areaSize;       //넓이 기준 내림차순 정렬. (뒤에서 앞에거 뺌)
            }
        };

        Collections.sort(blocks, comparator);       //정렬

        int[] dt = new int[n];              //높이 누적해서 더할 배열
        dt[0] = blocks.get(0).height;
        int maxHeight = 0, idx = 1, ans = 0;

        while(idx < n){
            maxHeight = 0;
            for(int i = idx -1; i >= 0; i--){
                if(blocks.get(i).weight > blocks.get(idx).weight){     //탑을 쌓을 수 있는 조건을 만족하고
                    if(dt[i] > maxHeight){      //누적 높이가 젤 큰 것을 채택
                        maxHeight = dt[i];
                    }
                }
            }
            dt[idx] = maxHeight + blocks.get(idx).height;
            if(dt[idx] > ans){
                ans = dt[idx];          //다이나믹 테이블의 최대값
            }
            idx++;
        }
        System.out.println(ans);

    }

}
