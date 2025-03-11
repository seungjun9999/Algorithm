class Solution {
    static int[] numbers;
    static int target, cnt, n;
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        n = numbers.length;
        return dfs(0, 0);
    }
    
    private int dfs(int sum, int dep) {
        if( n==dep && sum==target ) {
            cnt++;
        }
        if(n==dep) {
            return 0;
        }
        dfs(sum+numbers[dep], dep+1);
        dfs(sum-numbers[dep], dep+1);
        
        return cnt;
    }
}