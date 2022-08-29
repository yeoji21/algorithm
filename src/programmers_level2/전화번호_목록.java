package programmers_level2;

import java.util.*;

public class 전화번호_목록 {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>(Arrays.asList(phone_book));

        for (String phoneNumber : phone_book) {
            for (int i = 1; i < phoneNumber.length(); i++) {
                if(set.contains(phoneNumber.substring(0, i)))
                    return false;
            }
        }

        return true;
    }

    public boolean solution2(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            if(phone_book[i + 1].startsWith(phone_book[i]))
                return false;
        }

        return true;
    }
}
