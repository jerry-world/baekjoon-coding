import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int result = 0;

        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> discountMap = new HashMap<>();
            for (int j = i; j < i + 10; j++) {
                discountMap.put(discount[j], discountMap.getOrDefault(discount[j], 0) + 1);
            }

            if (isSignOkay(wantMap, discountMap)) {
                result++;
            }
        }

        return result;
    }

    private boolean isSignOkay(Map<String, Integer> wantMap, Map<String, Integer> discountMap) {
        for (Map.Entry<String, Integer> entry : wantMap.entrySet()) {
            if (discountMap.getOrDefault(entry.getKey(), 0) < entry.getValue()) return false;
        }

        return true;
    }
}