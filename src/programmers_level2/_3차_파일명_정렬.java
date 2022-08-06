package programmers_level2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class _3차_파일명_정렬 {
    public String[] solution(String[] files) {
        List<File> processedFile = new ArrayList<>(files.length * 2);

        for (int i = 0; i < files.length; i++) {
            String file = files[i];
            String original = file;
            String head = file.split("\\d+")[0];
            file = file.replace(head, "");
            String number = file.split("\\D+")[0];
            File newFile = new File(original, head, number, i);
            processedFile.add(newFile);
        }

        return processedFile.stream()
                .sorted(
                        Comparator.comparing((File file) -> file.head)
                                .thenComparing((File file) -> file.number)
                                .thenComparing((File file) -> file.idx)
                )
                .map(file -> file.originalName)
                .toArray(String[]::new);
    }

    class File{
        String originalName;
        String head;
        int number;
        int idx;

        public File(String originalName, String head, String number, int idx) {
            this.originalName = originalName;
            this.head = head.toLowerCase();
            this.number = Integer.parseInt(number);
            this.idx = idx;
        }
    }
}
