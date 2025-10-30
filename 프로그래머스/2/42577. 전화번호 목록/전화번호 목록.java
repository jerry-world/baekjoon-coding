import java.util.*;
// A
class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        Set<String> set = new HashSet<>();
        for (String s : phone_book) {
            set.add(s);
        }

        for (String s : phone_book) {
            for (int i = 1; i < s.length(); i++) {
                if(set.contains(s.substring(0,i))) return false;
            }
        }
        return true;
    }
}