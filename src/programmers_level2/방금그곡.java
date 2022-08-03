package programmers_level2;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 방금그곡 {
    public static void main(String[] args) {
        String solution = solution("ABC", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"});
        System.out.println(solution);
    }


    public static String solution(String m, String[] musicinfos) {
        List<Music> correctMusics = new ArrayList<>();
        String heared = parsing(m);
        int idx = 0;
        for (String musicinfo : musicinfos) {
            String[] infos = musicinfo.split(",");
            int playTime = getPlayTime(infos);

            String music = parsing(infos[3]);
            StringBuilder totalMusic = new StringBuilder();
            for (int i = 0; i < playTime; i++) {
                totalMusic.append(music.charAt(i % music.length()));
            }

            if(totalMusic.toString().contains(heared))
                correctMusics.add(new Music(infos[2], playTime, idx++));
        }

        if(correctMusics.size() == 0) return "(None)";

        return correctMusics.stream()
                .sorted(Comparator.comparing((Music music) -> music.playTime).reversed()
                        .thenComparing((Music music) -> music.index))
                .findFirst()
                .map(music -> music.title)
                .get();
    }

    private static int getPlayTime(String[] split) {
        String[] start = split[0].split(":");
        LocalTime startAt = LocalTime.of(Integer.parseInt(start[0]), Integer.parseInt(start[1]));

        String[] end = split[1].split(":");
        LocalTime endAt = LocalTime.of(Integer.parseInt(end[0]), Integer.parseInt(end[1]));

        return (int) Duration.between(startAt, endAt).toMinutes();
    }

    private static String parsing(String target) {
        target = target.replaceAll("C#", "H");
        target = target.replaceAll("D#", "I");
        target = target.replaceAll("F#", "J");
        target = target.replaceAll("G#", "K");
        return target.replaceAll("A#", "L");
    }

    static class Music {
        private String title;
        private int playTime;
        private int index;

        public Music(String title, int playTime, int index) {
            this.title = title;
            this.playTime = playTime;
            this.index = index;
        }
    }

}
