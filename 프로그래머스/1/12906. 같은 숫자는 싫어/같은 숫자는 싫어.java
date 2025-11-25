import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();

        int before = -1;
        for (Integer i : arr) {
            if(i.equals(before)) continue;
            before = i;
            list.add(i);
        }
        return list.stream().mapToInt(a -> a).toArray();
    }
}