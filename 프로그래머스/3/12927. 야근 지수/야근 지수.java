import java.util.*;

class Solution {

    public long solution(int n, int[] works) {
        //퇴근까지 남은시간 n
        //야근을 시작한 시점에서 남은 일의 작업량을 제곱하여 더한 값.
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) q.offer(work);

        while (n > 0 && !q.isEmpty()) {
            int poll = q.poll();
            if (poll == 0) break;
            q.offer(poll - 1);
            n--;
        }

        long sum = 0;
        while (!q.isEmpty()) {
            Integer poll = q.poll();
            sum += poll * poll;
        }

        return sum;
    }
}