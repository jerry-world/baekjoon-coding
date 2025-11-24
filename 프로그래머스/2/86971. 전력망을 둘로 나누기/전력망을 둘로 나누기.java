import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int solution(int n, int[][] wires) {
        List<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        //인접 리스트 생성
        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            graph[a].add(b);
            graph[b].add(a);
        }

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];

            boolean[] visited = new boolean[n + 1];
            int cnt = dfs(a, a, b, visited, graph);

            int diff = Math.abs(n - 2 * cnt);
            result = Math.min(diff, result);
        }

        return result;
    }

    private int dfs(int now, int blockA, int blockB, boolean[] visited, List<Integer>[] graph) {
        visited[now] = true;
        int cnt = 1;

        for (Integer next : graph[now]) {
            if((blockA == now && next == blockB) || (blockA == next && blockB == now)) continue;
            if(!visited[next]){
                visited[next] = true;
                cnt += dfs(next, blockA, blockB, visited, graph);
            }
        }

        return cnt;
    }
}
