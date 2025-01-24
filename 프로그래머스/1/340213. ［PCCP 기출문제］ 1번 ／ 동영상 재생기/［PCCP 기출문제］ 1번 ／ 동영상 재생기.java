import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        StringBuilder sb = new StringBuilder();
        
        int lastTime = convertToSeconds(video_len);
        int nowTime = convertToSeconds(pos);
        int opStart = convertToSeconds(op_start);
        int opEnd = convertToSeconds(op_end);
        
        if(nowTime >= opStart && nowTime <= opEnd) {
                nowTime = opEnd;
        }
        for (String command : commands) {
            nowTime += command.equals("next") ? 10 : -10;
            nowTime = Math.min(Math.max(0, nowTime), lastTime);
            if(nowTime >= opStart && nowTime <= opEnd) {
                nowTime = opEnd;
            }
        }
        return String.format("%02d:%02d", nowTime/60, nowTime%60);
    }
    
    private int convertToSeconds(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0])*60 + Integer.parseInt(parts[1]);
    }
}