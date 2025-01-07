import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        // 방법 1
        TreeSet<Integer> ts = new TreeSet<>();
        int n = numbers.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                ts.add(numbers[i]+numbers[j]);
            }
        }
        int[] result = new int[ts.size()];
        for(int i=0;i<result.length;i++){
            result[i] = ts.pollFirst();
        }
        return result;
        
        // 방법 2
        // List<Integer> answer = new ArrayList<>();
        // int n = numbers.length;
        // for(int i = 0; i < n-1; i++){
        //     for(int j = i+1; j < n; j++){
        //         answer.add( numbers[i] + numbers[j] );
        //     }
        // }
        // return answer.stream().sorted().distinct().mapToInt(Integer::intValue).toArray();
    }
}