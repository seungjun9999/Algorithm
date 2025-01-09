import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        
        int answer = 0;
        for(int i=0;i<moves.length;i++){
            int m = moves[i] - 1;
            for(int j=0;j<board.length;j++){
                if (board[j][m] != 0) {
                    if(dq.isEmpty() || dq.peek() != board[j][m]) {
                        dq.push(board[j][m]);
                    }else{
                        dq.pop();
                        answer += 2;
                    }
                    board[j][m] = 0;
                    break;
                }
            }
        }
        
        
        return answer;
    }
}