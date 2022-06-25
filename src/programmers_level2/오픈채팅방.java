package programmers_level2;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class 오픈채팅방 {
    static Map<String, String> nicknames = new HashMap<>();

    public String[] solution(String[] record) {
        List<Record> recordList = Arrays.stream(record)
                .map(Record::new).collect(Collectors.toList());

        return recordList.stream().filter(r -> r.commend != Commend.Change)
                .map(Record::convert)
                .toArray(String[]::new);
    }

    static class Record{
        Commend commend;
        String uid;

        public Record(String record) {
            String[] records = record.split(" ");
            commend = Commend.valueOf(records[0]);
            uid = records[1];
            if(commend != Commend.Leave) {
                nicknames.put(uid, records[2]);
            }
        }

        public String convert() {
            StringBuilder sb = new StringBuilder();
            sb.append(nicknames.get(uid));
            sb.append(commend.getComment());
            return sb.toString();
        }

    }

    enum Commend{
        Enter("님이 들어왔습니다."),
        Leave("님이 나갔습니다."),
        Change("");

        private final String comment;

        Commend(String comment) {
            this.comment = comment;
        }

        public String getComment() {
            return comment;
        }
    }

}
