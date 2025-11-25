import java.util.*;

public class Solution {
    public int solution(String dirs) {
        char[] moves = dirs.toCharArray();

        int x = 5;
        int y = 5;
        Set<String> channel = new HashSet<>();
        int cnt = 0;
        for (char move : moves) {
            switch (move) {
                case 'U': {
                    if (x - 1 < 0) continue;
                    String a = x + "," + y + "-" + (x - 1) + "," + y;
                    String b = (x - 1) + "," + y + "-" + x + "," + y;

                    if (!(channel.contains(a) || channel.contains(b))) cnt++;
                    channel.add(a);
                    channel.add(b);
                    x -= 1;
                    break;
                }
                case 'D': {
                    if (x + 1 > 10) continue;
                    String a = x + "," + y + "-" + (x + 1) + "," + y;
                    String b = (x + 1) + "," + y + "-" + x + "," + y;
                    if (!(channel.contains(a) || channel.contains(b))) cnt++;
                    channel.add(a);
                    channel.add(b);
                    x += 1;
                    break;
                }
                case 'L': {
                    if (y - 1 < 0) continue;
                    String a = x + "," + y + "-" + x + "," + (y - 1);
                    String b = x + "," + (y - 1) + "-" + x + "," + y;
                    if (!(channel.contains(a) || channel.contains(b))) cnt++;
                    channel.add(a);
                    channel.add(b);
                    y -= 1;
                    break;
                }
                case 'R': {
                    if (y + 1 > 10) continue;
                    String a = x + "," + y + "-" + x + "," + (y + 1);
                    String b = x + "," + (y + 1) + "-" + x + "," + y;
                    if (!(channel.contains(a) || channel.contains(b))) cnt++;
                    channel.add(a);
                    channel.add(b);
                    y += 1;
                    break;
                }
            }
        }

        return cnt;
    }
}