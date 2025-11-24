import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    class State {
        String val;
        int count;

        public State(String val, int count) {
            this.val = val;
            this.count = count;
        }
    }

    public int solution(String begin, String target, String[] words) {
        Queue<State> q = new LinkedList<>();
        q.offer(new State(begin, 0));

        boolean[] visited = new boolean[words.length];
        while (!q.isEmpty()) {
            State now = q.poll();
            String val = now.val;
            int count = now.count;

            if (val.equals(target)) {
                return count;
            }

            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                if (diffOnlyOne(val, word)) {
                    if (!visited[i]) {
                        visited[i] = true;
                        q.offer(new State(word, count + 1));
                    }
                }
            }
        }

        return 0;
    }
    private boolean diffOnlyOne(String val, String word) {
        int count = 0;
        for (int i = 0; i < val.length(); i++) {
            if (val.charAt(i) != word.charAt(i)) count++;
            if(count >1) return false;
        }

        return count == 1;
    }
}