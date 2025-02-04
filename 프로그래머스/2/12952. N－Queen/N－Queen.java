class Solution {
    static int[] num;
    static int answer,n;
    public int solution(int n) {
        num = new int[n];
        this.n = n;
        answer = 0;
        queen(0);
        
        return answer;
    }
    
    private void queen(int dep) {
        if(dep == n) {
            answer++;
            return;
        }
        
        for(int i=0;i<n;i++) {
            num[dep] = i;
            if(check(dep)) {
                queen(dep+1);
            }
        }
    }
    
    private boolean check(int idx) {
        for(int i=0;i<idx;i++) {
            if(num[i] == num[idx]) {
                return false;
            }else if(Math.abs(idx-i) == Math.abs(num[idx] - num[i])) {
                return false;
            }
        }
        return true;
    }
}