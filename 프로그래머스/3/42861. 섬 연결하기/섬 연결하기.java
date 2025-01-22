import java.util.*;

class Solution {
    static int[] parent;
    public int solution(int n, int[][] costs) {
        parent = new int[n];
        for(int i=0;i<n;i++) {
            parent[i] = i;
        }
        Arrays.sort(costs,(o1,o2) -> o1[2]-o2[2]);
        int select = 0;
        int cost = 0;
        for(int i=0;i<costs.length;i++) {
            if(find(costs[i][0]) != find(costs[i][1])) {
                select++;
                cost += costs[i][2];
                union(costs[i][0],costs[i][1]);
            }
            if(select == n-1) {
                return cost;
            }
        }
        return 0;
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