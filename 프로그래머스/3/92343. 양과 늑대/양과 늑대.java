import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int result = 0;

    public int solution(int[] info, int[][] edges) {
        for (int i = 0; i < info.length; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            list.get(edge[0]).add(edge[1]);
        }
        bfs(0, 0, 0, new HashSet<Integer>(), info);
        return result;
    }

    void bfs(int recent, int sheep, int wolf, HashSet<Integer> set, int[] info) {
        if (info[recent] == 0) {
            result = Math.max(result, ++sheep);
        } else {
            wolf += 1;
        }
        if (sheep <= wolf) {
            return;
        }
        set.addAll(list.get(recent));
        for (int a : set) {
            HashSet<Integer> visited = new HashSet<>(set);
            visited.remove(a);
            bfs(a, sheep, wolf, visited, info);
        }
    }
}