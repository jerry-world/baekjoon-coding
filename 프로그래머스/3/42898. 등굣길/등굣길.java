import java.util.*;

public class Solution {

    static int m;
    static int n;
    static int[][] puddles;
    static int[][] visited;

    public int solution(int m, int n, int[][] puddles) {
        this.m = m;
        this.n = n;
        this.puddles = puddles;
        this.visited = new int[m + 1][n + 1];

        for (int[] ints : visited) {
            Arrays.fill(ints, -1);
        }

        int i = goToSchool(1, 1);

        return i;
    }

    private int goToSchool(int x, int y) {
        if (x == m && y == n) return 1;

        if (isPuddle(x, y)) return 0;

        if(visited[x][y] != -1) return visited[x][y];

        int right = 0;
        int down = 0;
        if (x + 1 <= m) right = goToSchool(x + 1, y);
        if (y + 1 <= n) down = goToSchool(x, y + 1);

        return visited[x][y] = (right + down)  % 1_000_000_007;
    }

    private boolean isPuddle(int x, int y) {
        for (int[] puddle : puddles) {
            if (puddle[0] == x && puddle[1] == y) return true;
        }

        return false;
    }
}