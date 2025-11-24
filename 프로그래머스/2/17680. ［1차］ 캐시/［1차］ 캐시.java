import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize==0) return cities.length * 5;
        
        List<String> list = new LinkedList<>();

        int elapseTime = 0;
        for (String city : cities) {
            city = city.toLowerCase();
            if (list.contains(city)) {
                list.remove(city);
                list.add(city);
                elapseTime++;
            } else if (list.size() < cacheSize) {
                list.add(city);
                elapseTime += 5;
            }
            else {
                list.remove(0);
                list.add(city);
                elapseTime += 5;
            }
        }

        return elapseTime;
    }
}
