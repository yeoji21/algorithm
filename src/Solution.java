import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {


    }

    public String[] solution(String[] record) {
        List<Record> result = new ArrayList<>();
        Map<String, String> nicknames = new HashMap<>();

        for (String row : record) {
            String[] split = row.split(" ");
            String command = split[0];

            if (command.equals("Enter")) {
                String uuid = split[1];
                String nickname = split[2];
                nicknames.put(uuid, nickname);
                result.add(new Record(command, uuid));
            } else if (command.equals("Leave")) {
                result.add(new Record(command, split[1]));
            } else if (command.equals("Change")) {
                String uuid = split[1];
                String nickname = split[2];
                nicknames.put(uuid, nickname);
            }
        }

        return result.stream()
                .map(r -> {
                    String nickname = nicknames.get(r.uuid);
                    if (r.command.equals("Enter")) {
                        return nickname + "님이 들어왔습니다.";
                    } else if (r.command.equals("Leave")) {
                        return nickname + "님이 나갔습니다.";
                    }
                    return null;
                })
                .toArray(String[]::new);
    }

    static class Record{
        String command;
        String uuid;

        public Record(String command, String uuid) {
            this.command = command;
            this.uuid = uuid;
        }
    }
}
