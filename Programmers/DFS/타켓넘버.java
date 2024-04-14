package Programmers.DFS;

import java.io.*;
import java.util.*;

class Solution {
    static int cnt = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return cnt;
    }

    public void dfs(int[] num, int target, int a, int sum) {
        if (a == num.length) {
            if (target == sum) {
                cnt += 1;
            }
            return;
        }
        dfs(num, target, a + 1, sum + num[a]);
        dfs(num, target, a + 1, sum - num[a]);
    }
}
