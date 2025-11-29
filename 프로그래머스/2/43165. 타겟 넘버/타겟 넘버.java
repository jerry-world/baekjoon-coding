public class Solution {
    static boolean[] visited;
    static int[] numbers;
    static int target;
    static int correctNum;

    public int solution(int[] numbers, int target) {
        this.target = target;
        this.numbers = numbers;
        this.visited = new boolean[numbers.length];

        dfs(0, 0);

        return correctNum;
    }

    private void dfs(int idx, int now) {
        if (idx == numbers.length) {
            if (now == target) correctNum++;
            return;
        }
        dfs(idx + 1, now + numbers[idx]);
        dfs(idx + 1, now - numbers[idx]);
    }

}