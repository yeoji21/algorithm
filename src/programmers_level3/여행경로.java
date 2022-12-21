package programmers_level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 여행경로 {
    private boolean[] checked;
    private List<String> answer;
    public String[] solution(String[][] tickets) {
        answer = new ArrayList<>();
        checked = new boolean[tickets.length];

        DFS(0, tickets, "ICN", "ICN");
        Collections.sort(answer);

        return answer.get(0).split(" ");
    }

    void DFS(int level, String[][] tickets, String start, String route){
        if(level == tickets.length){
            answer.add(route);
            return;
        }

        for(int i = 0; i < tickets.length; i++){
            if(checked[i]) continue;
            if(!start.equals(tickets[i][0])) continue;

            checked[i] = true;
            DFS(level + 1, tickets, tickets[i][1], route + " " + tickets[i][1]);
            checked[i] = false;
        }
    }
}
