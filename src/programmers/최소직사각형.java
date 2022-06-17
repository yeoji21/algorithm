package programmers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 최소직사각형 {
    public int solution(int[][] sizes) {
        List<BusinessCard> businessCards = Arrays.stream(sizes)
                .map(size -> new BusinessCard(size[0], size[1]))
                .collect(Collectors.toList());

        int maxWidth = Integer.MIN_VALUE, maxHeight = Integer.MIN_VALUE;

        for (BusinessCard businessCard : businessCards) {
            maxWidth = Math.max(businessCard.width, maxWidth);
            maxHeight = Math.max(businessCard.height, maxHeight);
        }

        return maxHeight * maxWidth;
    }

    class BusinessCard{
        int width, height;

        public BusinessCard(int width, int height) {
            this.width = Math.max(width, height);
            this.height = Math.min(width, height);
        }
    }
}
