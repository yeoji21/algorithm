package programmers_level3;

import java.util.*;

public class 가장_먼_노드 {
    public int solution(int n, int[][] edge) {
        boolean[] checked = new boolean[n + 1];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 1; i < n + 1; i++){
            map.put(i, new ArrayList<>());
        }

        for(int i = 0; i < edge.length; i ++){
            map.get(edge[i][0]).add(edge[i][1]);
            map.get(edge[i][1]).add(edge[i][0]);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        checked[1] = true;
        int answer = 0;

        while(!q.isEmpty()){
            int size = q.size();
            if(size != 0) answer = size;
            while(size -- > 0){
                int poll = q.poll();
                List<Integer> list = map.get(poll);
                for(int node : list){
                    if(checked[node]) continue;
                    checked[node] = true;
                    q.add(node);
                }
            }
        }

        return answer;
    }
}
