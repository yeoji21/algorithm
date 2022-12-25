package leetcode;

import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int i;
        for(i = 0; i < strs[0].length(); i++){
            boolean match = true;
            for(int j = 0; j < strs.length; j++){
                if(strs[j].charAt(i) != strs[0].charAt(i)){
                    match = false;
                    break;
                }
            }
            if(!match) break;
        }

        return i > 0 ? strs[0].substring(0, i) : "";
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int c = 0;
        while(c < first.length())
        {
            if (first.charAt(c) == last.charAt(c))
                c++;
            else
                break;
        }
        return c == 0 ? "" : first.substring(0, c);
    }

    public String longestCommonPrefix3(String[] strs) {
        String prefix = strs[0];
        for(int index=1;index<strs.length;index++){
            while(strs[index].indexOf(prefix) != 0){
                prefix=prefix.substring(0,prefix.length()-1);
            }
        }
        return prefix;
    }

}
