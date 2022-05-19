package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 신고_결과_받기 {

    public int[] anotherSolution(String[] id_list, String[] report, int k) {
        List<String> reportList = Arrays.stream(report).distinct().collect(Collectors.toList());
        Map<String, Integer> count = new HashMap<>();

        reportList.forEach(reportSheet -> {
            String target = reportSheet.split(" ")[1];
            count.put(target, count.getOrDefault(target, 0) + 1);
        });

        return Arrays.stream(id_list).map(user -> {
            List<String> list = reportList.stream().filter(s -> s.startsWith(user+ " ")).collect(Collectors.toList());
            return list.stream().filter(s -> count.getOrDefault(s.split(" ")[1], 0) >= k).count();
        }).mapToInt(Long::intValue).toArray();
    }

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] result = new int[id_list.length];
        Map<String, String> reported = new HashMap<>();
        Arrays.stream(id_list).forEach(id -> reported.put(id, "0".repeat(id_list.length)));

        Arrays.stream(report)
                .forEach(reportSheet -> {
                    String complainant = reportSheet.split(" ")[0];
                    String defendant = reportSheet.split(" ")[1];

                    int offset = getOffset(id_list, complainant);
                    reported.put(defendant, updateReportedString(reported.get(defendant), offset));
                });

        reported.entrySet()
                .forEach(es -> {
                    if (getReportedCount(id_list, es.getValue()) >= k) {
                        IntStream.range(0, id_list.length)
                                .filter(i -> es.getValue().charAt(i) == '1')
                                .forEach(i -> result[i]++);
                    }
                });
        return result;
    }

    private long getReportedCount(String[] id_list, String reported) {
        return IntStream.range(0, id_list.length)
                .filter(i -> reported.charAt(i) == '1')
                .count();
    }

    private String updateReportedString(String reported, int offset) {
        return reported.substring(0, offset) + "1" + reported.substring(offset + 1);
    }

    private int getOffset(String[] id_list, String id) {
        return IntStream.range(0, id_list.length)
                .filter(i -> id_list[i].equals(id))
                .findAny().getAsInt();
    }
}
