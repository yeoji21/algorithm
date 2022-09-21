package programmers_level2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class _3차_파일명_정렬 {
    public static String[] solution(String[] files) {
        List<File> fileList = new ArrayList<>();

        for (int i = 0; i < files.length; i++) {
            String file = files[i];
            String head = file.split("\\d")[0];
            file = file.replace(head, "");
            int number = Integer.parseInt(file.split("\\D")[0]);
            fileList.add(new File(head, number, i));
        }

        fileList.sort(Comparator.comparing((File f) -> f.head)
                .thenComparing((File f) -> f.number)
                .thenComparing((File f) -> f.idx));

        return fileList.stream()
                .map(f -> files[f.idx])
                .toArray(String[]::new);
    }

    static class File{
        private String head;
        private int number;
        private int idx;

        public File(String head, int number, int idx) {
            this.head = head.toLowerCase();
            this.number = number;
            this.idx = idx;
        }
    }
}
