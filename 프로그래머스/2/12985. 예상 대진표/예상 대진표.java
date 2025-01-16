class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer=1;
        while(Math.abs(b-a)!=1 || (int)Math.ceil((double)b/2) != (int)Math.ceil((double)a/2)) {
            b= (int)Math.ceil((double)b/2);
            a= (int)Math.ceil((double)a/2);
            answer++;
        }
        return answer;
    }
}