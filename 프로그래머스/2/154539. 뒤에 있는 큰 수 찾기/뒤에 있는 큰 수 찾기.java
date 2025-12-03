import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty()) {
                if (stack.peek() <= numbers[i]) {
                    stack.pop();
                } else {
                    answer[i] = stack.peek();
                    break;
                }
            }
            if (stack.isEmpty()) {
                answer[i] = -1;
            }
            stack.push(numbers[i]);
        }

        return answer;
    }
}