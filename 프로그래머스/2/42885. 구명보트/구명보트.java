import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int now=limit;
        Arrays.sort(people);
        int l = people.length-1;
        int i = 0;
        while(l>=i){
            if(people[l] + people[i] <= limit) {
                i++;
            }
            l--;
            answer++;
        }
        
        return answer;
    }
}