import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
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
        
        // int[] answer = {};
        // int n = numbers.length;
        // int cnt=0;
        // for(int i = 0; i < n-1; i++){
        //     for(int j = i+1; j < n; j++){
        //         answer[cnt] = numbers[i] + numbers[j] ;
        //         cnt++;
        //     }
        // }
        // Integer[] array = Arrays.stream(answer).boxed().distinct().toArray(Integer[]::new);
        // Arrays.sort(array);
        // return Arrays.stream(array).mapToInt(Integer::intValue).toArray();
    }
}