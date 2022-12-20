package programmers_level3;

import java.util.Arrays;
import java.util.Comparator;

public class 섬_연결하기 {
    private int[] union;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        union = new int[n];
        for(int i = 0; i < union.length; i++){
            union[i] = i;
        }
        Arrays.sort(costs, Comparator.comparing(b -> b[2]));

        for(int i = 0; i < costs.length; i++){
            if(union(costs[i]))
                answer += costs[i][2];
        }

        return answer;
    }

    boolean union(int[] costs){
        int a = find(costs[0]);
        int b = find(costs[1]);
        if(a == b) return false;

        if(a > b){
            union[a] = b;
        } else if(b > a){
            union[b] = a;
        }
        return true;
    }

    int find(int node){
        if(node == union[node]) return node;
        return union[node] = find(union[node]);
    }
}
