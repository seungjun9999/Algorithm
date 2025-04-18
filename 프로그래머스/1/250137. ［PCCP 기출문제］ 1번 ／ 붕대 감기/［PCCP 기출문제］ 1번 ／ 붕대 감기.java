class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int t=1;
        int aIdx=0;
        int bIdx=1;
        int mH = health;
        int last = attacks[attacks.length-1][0] ; 
        while(t <= last) {
            if(t==attacks[aIdx][0]) {
                health -= attacks[aIdx][1];
                aIdx++;
                bIdx=1;
                if(health <= 0) {
                    return -1;
                }
            }else {
                health += bandage[1];
                if(bIdx == bandage[0]) {
                    health += bandage[2];
                    bIdx=0;
                }
                bIdx++;
            }
            if(health>mH) {
                health = mH;
            }
            t++;
        }
        return health;
    }
}