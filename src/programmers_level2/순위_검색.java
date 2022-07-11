package programmers_level2;

import java.util.*;

public class 순위_검색 {
    public static void main(String[] args) {
        int[] solution = solution(new String[]{"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"}
                , new String[]{"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"});

        System.out.println("==================");
        Arrays.stream(solution).forEach(System.out::println);
    }

    public static int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> search = new HashMap<>();
        List<Participant> participants = new ArrayList<>();
        initializeInfo(info, search, participants);

        int[] result = new int[query.length];

        for (int i = 0; i < query.length; i++) {
            String[] conditions = query[i].split(" and ");
            int anywayCount = 0;
            int score = Integer.MAX_VALUE;

            Map<Integer, Integer> map = null;

            for (int c = 0; c < conditions.length; c++) {
                String condition = conditions[c];
                if(c == conditions.length - 1){
                    condition = conditions[conditions.length - 1].split(" ")[0];
                    score = Integer.parseInt(conditions[conditions.length - 1].split(" ")[1]);
                }

                if(condition.equals("-")){
                    anywayCount++;
                    continue;
                }

                List<Integer> idxList = search.get(condition);
                if(idxList == null) continue;

                if(map == null){
                    map = new HashMap<>();
                    for (int idx = 0; idx < idxList.size(); idx++) {
                        map.put(idxList.get(idx), 1);
                    }
                }
                else {
                    for (int idx = 0; idx < idxList.size(); idx++) {
                        map.put(idxList.get(idx), map.getOrDefault(idxList.get(idx), 0) + 1);
                    }
                }
            }

            if(anywayCount == 4){
                for (Participant participant : participants) {
                    if(participant.score >= score) result[i]++;
                }
                continue;
            }

            for (Map.Entry<Integer, Integer> es : map.entrySet()) {
                if(es.getValue() == 4 - anywayCount && score <= participants.get(es.getKey()).score)
                    result[i]++;
            }
        }

        // TODO: 2022/07/11 https://velog.io/@jh5253/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%88%9C%EC%9C%84%EA%B2%80%EC%83%89-Java%EC%9E%90%EB%B0%9
        // https://gwang920.github.io/algorithm/progreammers-1-72412/
        return result;
    }

    private static void initializeInfo(String[] info, Map<String, List<Integer>> search, List<Participant> participants) {
        for (int i = 0; i < info.length; i++) {
            String[] keywords = info[i].split(" ");
            for (int k = 0; k < keywords.length - 1; k++) {
                String keyword = keywords[k];
                if (!search.containsKey(keyword)) {
                    List<Integer> idxList = new ArrayList<>();
                    idxList.add(i);
                    search.put(keyword, idxList);
                }
                else {
                    search.get(keyword).add(i);
                }
            }
            participants.add(i, new Participant(Integer.parseInt(keywords[keywords.length - 1])));
        }
    }

    private static class Participant {
        private int score;

        public Participant(int score) {
            this.score = score;
        }
    }
}
