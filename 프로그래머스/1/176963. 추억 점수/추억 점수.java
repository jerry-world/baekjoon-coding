import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photos) {
        int[] result = new int[photos.length];

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }


        for (int i = 0; i < photos.length; i++) {
            String[] photo = photos[i];
            int sum = 0;
            for (String s : photo) {
                sum += map.getOrDefault(s, 0);
            }
            result[i] = sum;
        }

        return result;
    }
}