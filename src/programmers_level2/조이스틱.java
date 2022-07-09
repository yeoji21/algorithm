package programmers_level2;

public class 조이스틱 {
    public int solution(String name) {
        int count = 0;
        int move = name.length() - 1;

        for (int i = 0; i < name.length(); i++) {
            count += getUpDownCount(name.charAt(i));

            if (i < name.length() - 1 && name.charAt(i + 1) == 'A') {
                int lengthA = i + 1;
                while (lengthA < name.length() && name.charAt(lengthA) == 'A')
                    lengthA += 1;
                move = Math.min(move, i * 2 + (name.length() - lengthA));
                move = Math.min(move, i + (name.length() - lengthA) * 2);
            }
        }

        return count + move;
    }

    private int getUpDownCount(char array) {
        return Math.min(Math.abs('A' - array), Math.abs('Z' - array) + 1);
    }
}
