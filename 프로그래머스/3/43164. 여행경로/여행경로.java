import java.util.*;

public class Solution {
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, ((a, b) -> {
            int i = a[0].compareTo(b[0]);
            if (i == 0) return a[1].compareTo(b[1]);
            else return i;
        }));

        boolean[] visited = new boolean[tickets.length];

        List<String> nowList = new ArrayList<>();
        List<String> result = new ArrayList<>();
        nowList.add("ICN");
        dfs("ICN", tickets, visited, nowList, result);

        return result.toArray(String[]::new);
    }

    private void dfs(String now, String[][] ticket, boolean[] visited, List<String> nowList, List<String> result) {
        if (nowList.size() == ticket.length + 1){
            if(result.isEmpty()) result.addAll(nowList);
            return;
        }

        for (int i = 0; i < ticket.length; i++) {
            String src = ticket[i][0];
            String dest = ticket[i][1];

            if (src.equals(now) && !visited[i]) {
                visited[i] = true;
                nowList.add(dest);
                dfs(dest, ticket, visited, nowList, result);
                nowList.remove(nowList.size() - 1);
                visited[i] = false;
            }
        }
    }
}