import java.util.*;

class Solution {
    static int n, select = 0, answer = 0;
    static int[] parent;
    public int solution(int n, int[][] costs) {
        this.n = n;
        parent = new int[n];
        for(int i=0;i<n;i++) {
            parent[i] = i;
        }
        Arrays.sort(costs,(o1,o2) -> o1[2] - o2[2]);
        for(int[] cost : costs) {
            if(find(cost[0]) != find(cost[1])) {
                union(cost[0],cost[1]);
                answer += cost[2];
                if(++select == n-1) {
                    break;
                }
            }
        }
        return answer;
    }
    
    static int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }
    
    static void union(int x,int y) {
        int root1 = find(x);
        int root2 = find(y);
        parent[root2] = root1;
    }
}