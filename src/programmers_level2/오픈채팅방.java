package programmers_level2;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 오픈채팅방 {
    public String[] solution(String[] record) {
        Map<String, String> nicknames = new HashMap<>();
        List<Message> messages = new ArrayList<>();

        for (String row : record) {
            String[] splited = row.split(" ");
            String command = splited[0];
            String userId = splited[1];
            Message message = new Message(command, userId);

            if (command.equals("Enter")) {
                nicknames.put(userId, splited[2]);
                messages.add(message);
            } else if (command.equals("Leave")) {
                messages.add(message);
            }else {
                nicknames.put(userId, splited[2]);
            }
        }

        return messages.stream()
                .map(m -> {
                    if (m.command.equals("Enter")) {
                        return nicknames.get(m.userId) + "님이 들어왔습니다.";
                    } else if (m.command.equals("Leave")) {
                        return nicknames.get(m.userId) + "님이 나갔습니다.";
                    }
                    return null;
                }).toArray(String[]::new);
    }

    static class Message{
        private String command;
        private String userId;

        public Message(String command, String userId) {
            this.command = command;
            this.userId = userId;
        }
    }

}
