package programmers_level2;

import java.time.Duration;
import java.time.LocalTime;

public class 방금그곡 {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int answerLength = 0;
        m = convert(m);

        for (String musicinfo : musicinfos) {
            String[] split = musicinfo.split(",");
            int playTime = getPlayTime(split);

            String music = convert(split[3]);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < playTime; i++) {
                sb.append(music.charAt(i % music.length()));
            }

            String playedMusic = sb.toString();
            if(! playedMusic.contains(m)) continue;

            if (playTime > answerLength) {
                answer = split[2];
                answerLength = playTime;
            }
        }

        return answer;
    }

    private int getPlayTime(String[] split) {
        LocalTime startTime = toLocalTime(split[0]);
        LocalTime endTime = toLocalTime(split[1]);
        return Math.abs((int) Duration.between(endTime, startTime).toMinutes());
    }

    private LocalTime toLocalTime(String musicinfo) {
        return LocalTime.of(Integer.parseInt(musicinfo.split(":")[0]), Integer.parseInt(musicinfo.split(":")[1]));
    }

    private String convert(String target) {
        target = target.replace("C#", "1");
        target = target.replace("D#", "2");
        target = target.replace("F#", "3");
        target = target.replace("G#", "4");
        target = target.replace("A#", "5");
        return target;
    }
}
