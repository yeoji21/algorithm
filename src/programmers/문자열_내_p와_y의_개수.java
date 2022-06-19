package programmers;

public class 문자열_내_p와_y의_개수 {

    boolean solution(String s) {
        String lowerCase = s.toLowerCase();
        int pCount = 0;
        int yCount = 0;

        for (char alphabet : lowerCase.toCharArray()) {
            if(alphabet == 'p') pCount++;
            if(alphabet == 'y') yCount++;
        }

        return pCount == yCount;
    }
}
