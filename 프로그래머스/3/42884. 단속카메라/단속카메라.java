import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, (o1,o2) -> {
           if(o1[0]==o2[0]) {
               return o1[1] - o2[1];
           }
            return o1[0] - o2[0]; 
        });
        
        int left = routes[0][0];
        int right = routes[0][1];
        
        for(int[] route : routes) {
            if(route[0] <= right) left = route[0];
            if(route[1] <= right) right = route[1];
            if(route[0] > right){
                answer++;
                left = route[0];
                right = route[1];
            }
        }
        return answer;
    }
}