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
            while (totalMusic.length() < playTime) {
                for (int i = 0; i < music.length(); i++) {
                    totalMusic.append(music.charAt(i));
                }
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
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < target.length(); i++) {
            if (i + 1 < target.length() && target.charAt(i + 1) == '#') {
                char ch = target.charAt(i);
                if(ch == 'C'){
                    sb.append('1');
                }else if(ch == 'D'){
                    sb.append('2');
                } else if (ch == 'F') {
                    sb.append('3');
                } else if (ch == 'G') {
                    sb.append('4');
                } else if (ch == 'A') {
                    sb.append('5');
                } else {
                    throw new IllegalArgumentException();
                }
                i++;
            }else{
                sb.append(target.charAt(i));
            }
        }

        return sb.toString();
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
