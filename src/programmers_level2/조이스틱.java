package programmers_level2;

public class 조이스틱 {
    public int solution(String name) {
        int count = 0;
        // 오른쪽으로만 쭉 이동한 횟수
        int move = name.length() - 1;

        for (int i = 0; i < name.length(); i++) {
            count += getUpDownCount(name.charAt(i));

            if (i < name.length() - 1 && name.charAt(i + 1) == 'A') {
                int lengthA = i + 1;
                while (lengthA < name.length() && name.charAt(lengthA) == 'A')
                    lengthA += 1;
                // BBBAAAAAABA라고 할 때, i + 2는 중간까지 왔다가 다시 뒤로 돌아갈 때의 조이스틱 이동 횟수
                // name.length() - lengthA는 오른쪽 두 번째 B까지 위치이다.
                move = Math.min(move, i * 2 + (name.length() - lengthA));
                // BBBBAAAAAAAB와 같이 처음부터 뒷부분을 먼저 입력하는 것이 더 빠른 경우까지 고려
                move = Math.min(move, i + (name.length() - lengthA) * 2);
            }
        }

        return count + move;
    }

    private int getUpDownCount(char array) {
        return Math.min(Math.abs('A' - array), Math.abs('Z' - array) + 1);
    }
}
