import java.util.*;

public class Solution {
    public int solution(int n, int[][] computers) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[i].length; j++) {
                if (computers[i][j] == 1 && i != j) {
                    graph[i].add(j);
                }
            }
        }


        int cnt = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, graph, visited);
                cnt++;
            }
        }

        return cnt;
    }

    private void dfs(int now, List<Integer>[] graph, boolean[] visited) {
        if (visited[now]) return;

        visited[now] = true;

        for (int next : graph[now]) {
            if (!visited[next]) {
                dfs(next, graph, visited);
            }
        }
    }
}