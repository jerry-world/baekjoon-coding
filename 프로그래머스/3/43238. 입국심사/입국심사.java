import java.util.*;

public class Solution {
    public long solution(int n, int[] times) {
        long left = 1;
        long right = (long) Arrays.stream(times).max().orElse(0) * n;

        long answer = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (canFinish(mid, times, n)) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    private boolean canFinish(long mid, int[] times, int n) {
        long sum = 0;
        for (int time : times) {
            sum += mid / time;
            if (sum >= n) return true;
        }

        return false;
    }
}