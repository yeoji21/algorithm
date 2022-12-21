package programmers_level3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 디스크_컨트롤러 {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, Comparator.comparing(j -> j[0]));
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparing(j -> j[1]));

        int answer = 0;
        int now = 0;
        int idx = 0;
        int count = 0;

        while(count < jobs.length){
            while(idx < jobs.length && jobs[idx][0] <= now){
                q.add(jobs[idx++]);
            }

            if(q.isEmpty()){
                now = jobs[idx][0];
            }else{
                int[] job = q.poll();
                answer += now - job[0] + job[1];
                now += job[1];
                count++;
            }
        }

        return answer / jobs.length;
    }
}
