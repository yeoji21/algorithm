package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class 키패드_누르기 {
    private static String LEFT = "L";
    private static String RIGHT = "R";
    private static int[][] keypad = new int[4][3];
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public String solution(int[] numbers, String hand) {
        Hands hands = new Hands(hand);

        return Arrays.stream(numbers)
                .mapToObj(hands::press)
                .collect(Collectors.joining());
    }

    private static class Hands{
        private Location leftHand;
        private Location rightHand;
        private String preferHand;

        static {
            for (int i = 0, num = 1; i < 3; i++) {
                for (int j = 0; j < 3; j++, num++) {
                    keypad[i][j] = num;
                }
            }
        }

        public Hands(String preferHand) {
            this.preferHand = preferHand.equals("right") ? RIGHT : LEFT;
            leftHand = new Location(3, 0);
            rightHand = new Location(3, 2);
        }

        public String press(int number) {
            if (number == 1 || number == 4 || number == 7) return updateLeftLocation(number);
            if (number == 3 || number == 6 || number == 9) return updateRightLocation(number);

            else{
                int leftDistance = distanceToMove(leftHand, number);
                int rightDistance = distanceToMove(rightHand, number);

                if(leftDistance == rightDistance) {
                    if(preferHand.equals(LEFT)) return updateLeftLocation(number);
                    else return updateRightLocation(number);
                }
                else {
                    if (leftDistance < rightDistance) return updateLeftLocation(number);
                    else return updateRightLocation(number);
                }
            }
        }

        private Location findLocation(int number) {
            if(number == 0) return new Location(3, 1);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(keypad[i][j] == number)
                        return new Location(i, j);
                }
            }
            return null;
        }

        private String updateRightLocation(int number) {
            rightHand = findLocation(number);
            return RIGHT;
        }

        private String updateLeftLocation(int number) {
            leftHand = findLocation(number);
            return LEFT;
        }

        private int distanceToMove(Location location, int target) {
            Queue<Location> queue = new LinkedList<>();
            boolean[][] checked = new boolean[4][3];
            queue.add(location);
            checked[location.x][location.y] = true;

            int count = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    Location now = queue.poll();
                    if(keypad[now.x][now.y] == target) return count;

                    for (int i = 0; i < 4; i++) {
                        int nx = now.x + dx[i];
                        int ny = now.y + dy[i];

                        if(nx >= 4 || nx < 0 || ny >= 3 || ny < 0 || checked[nx][ny]) continue;
                        if(nx == 3 && ny == 0 || nx == 3 && ny == 2) continue;

                        queue.add(new Location(nx, ny));
                        checked[nx][ny] = true;
                    }
                }
                count++;
            }

            return -1;
        }
    }

    private static class Location{
        int x, y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
