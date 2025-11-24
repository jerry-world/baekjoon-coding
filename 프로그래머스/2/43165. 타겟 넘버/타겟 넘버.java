import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int solution(int[] numbers, int target) {
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{numbers[0], 0});
        q.offer(new int[]{-numbers[0], 0});

        int count = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int val = now[0];
            int idx = now[1];
            if (val == target && idx == numbers.length - 1) {
                count++;
                continue;
            }
            if (idx == numbers.length - 1) {
                continue;
            }

            q.offer(new int[]{val + numbers[idx + 1], idx + 1});
            q.offer(new int[]{val - numbers[idx + 1], idx + 1});
        }

        return count;
    }

}
