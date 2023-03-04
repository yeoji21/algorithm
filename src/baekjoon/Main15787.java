package baekjoon;

import java.io.*;
import java.util.*;

public class Main15787 {
    /*
    1번부터 N개의 기차는 각각 20개의 일렬로 된 좌석이 있음
    어떤 기차에 대해 M개의 명령이 주어짐
    1 i x : i번 기차 x번에 승차
    2 i x : i번 기차 x번 하차
    3 i : i번째 기차 사람들 모두 뒤로 한 칸(20번 하차)
    4 i : i번째 기차 사람들 모두 앞으로 한칸 (1번 하차)

    이전에 나왔던 좌석 배치로 지나갈 수 없음
    은하수를 건널 수 있는 기차의 수를 구하시오
    */
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int n = getIntToken(tokenizer);
        int m = getIntToken(tokenizer);
        boolean[][] trains = new boolean[n + 1][21];

        while(m-- > 0){
            tokenizer = new StringTokenizer(br.readLine());
            int command = getIntToken(tokenizer);
            int train = getIntToken(tokenizer);

            if(command == 1){
                int target = getIntToken(tokenizer);
                trains[train][target] = true;
            }else if(command == 2){
                int target = getIntToken(tokenizer);
                trains[train][target] = false;
            }else if(command == 3){
                for(int i = 20; i >= 1; i--){
                    trains[train][i] = trains[train][i - 1];
                }
                trains[train][1] = false;
            }else{
                for(int i = 1; i < 20; i++){
                    trains[train][i] = trains[train][i + 1];
                }
                trains[train][20] = false;
            }
        }
        Set<String> set = new HashSet<>();
        int count = 0;
        for(int i = 1; i < n + 1; i++){
            StringBuilder train = new StringBuilder();
            for(boolean seat : trains[i]){
                if(seat) train.append("1");
                else train.append("0");
            }
            if(set.contains(train.toString())){
                continue;
            }
            set.add(train.toString());
            count++;
        }
        System.out.println(count);
    }

    public static void main(String[] args) throws Exception {
        new Main15787().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
