package programmers_level3;

import java.util.*;

class 베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Record> map = new HashMap<>();
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < genres.length; i++) {
            if (map.containsKey(genres[i])) {
                Record record = map.get(genres[i]);
                record.addSong(i, plays[i]);
            }else{
                Record record = new Record();
                record.addSong(i, plays[i]);
                map.put(genres[i], record);
            }
        }

        List<Record> records = new ArrayList<>(map.values());
        Collections.sort(records, Comparator.comparing(r -> r.sum * -1));
        for (Record record : records) {
            Collections.sort(record.idx, Comparator.comparing((Integer idx) -> plays[idx] * -1)
                    .thenComparing((Integer idx) -> idx));
            answer.add(record.idx.get(0));
            if(record.idx.size() > 1) answer.add(record.idx.get(1));
        }

        return answer.stream()
                .mapToInt(x -> x)
                .toArray();
    }

    class Record{
        private int sum;
        private List<Integer> idx;

        public Record() {
            this.sum = 0;
            idx = new ArrayList<>();
        }

        public void addSong(int idx, int playTime) {
            this.idx.add(idx);
            this.sum += playTime;
        }
    }
}
