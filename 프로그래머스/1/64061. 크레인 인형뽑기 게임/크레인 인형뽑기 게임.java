import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        List<Queue<Integer>> boardList = new ArrayList<>();

        for (int col = 0; col < board[0].length; col++) {
            Queue<Integer> q = new LinkedList<>();
            for (int row = 0; row < board.length; row++) {
                int doll = board[row][col];
                if (doll != 0) {
                    q.offer(doll);
                }
            }
            boardList.add(q);
        }

        int pop = 0;
        Stack<Integer> stack = new Stack<>();
        for (int move : moves) {
            int idx = move - 1;

            if(!boardList.get(idx).isEmpty()) {
                Integer now = boardList.get(idx).poll();
                if (!stack.isEmpty() && stack.peek().equals(now)) {
                    stack.pop();
                    pop += 2;
                } else {
                    stack.push(now);
                }
            }
        }

        return pop;
    }
}