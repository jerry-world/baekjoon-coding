import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        List<String> babList = List.of("aya", "ye", "woo", "ma");
        int result = 0;

        for (String s : babbling) {
            int idx = 0;
            String last = "";
            boolean matched = false;
            while (idx < s.length()) {
                for (String bab : babList) {
                    if (s.startsWith(bab, idx) && !bab.equals(last)) {
                        idx += bab.length();
                        last = bab;
                        matched = true;
                        break;
                    } else {
                        matched = false;
                    }
                }
                if (!matched) break;
            }
            if(matched) result++;
        }

        return result;
    }

}
