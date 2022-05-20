package programmers;

public class 신규_아이디_추천 {

    public static String solution(String new_id) {
        return new KaKaoId(new_id).getId();
    }

    private static class KaKaoId {
        private String id;

        public KaKaoId(String new_id) {
            id = new_id;
            toLowerCase();
            removeSpecialCharacters();
            toSingleDot();
            removePrefixOrSubfixDot();
            replaceEmptyString();
            maxLengthLimit();
            minLengthLimit();
        }

        private void toLowerCase() {
            id = id.toLowerCase();
        }

        private void minLengthLimit() {
            while (id.length() < 3) id = id.concat(String.valueOf(id.charAt(id.length() - 1)));
        }

        private void maxLengthLimit() {
            if(id.length() > 15) {
                id = id.substring(0, 15);
                if(id.endsWith(".")) id = id.substring(0, id.length() - 1);
            }
        }

        private void replaceEmptyString() {
            if(id.length() == 0) id = "a";
        }

        private void removePrefixOrSubfixDot() {
            if(id.startsWith(".")) id = id.substring(1);
            if(id.endsWith(".")) id = id.substring(0, id.length() - 1);
        }

        private void toSingleDot() {
            id = id.replaceAll("[.]+", ".");
        }

        private void removeSpecialCharacters() {
            id = id.replaceAll("[^a-z\\d\\-_.]", "");
        }

        public String getId() {
            return id;
        }
    }
}
