import java.util.*;

class Solution {
    Map<String, String> map = Map.of(
        "zero", "0",
        "one", "1",
        "two", "2",
        "three", "3",
        "four", "4",
        "five", "5",
        "six", "6",
        "seven", "7",
        "eight", "8",
        "nine", "9"
    );

    public int solution(String s) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            s = s.replaceAll(entry.getKey(), entry.getValue());
        }

        return Integer.parseInt(s);
    }
}