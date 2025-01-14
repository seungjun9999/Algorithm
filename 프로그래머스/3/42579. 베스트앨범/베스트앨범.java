import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String,Integer> totalSong = new HashMap<>();
        HashMap<String,ArrayList<int[]>> genresSong = new HashMap<>();
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0; i < genres.length; i++) {
            totalSong.put(genres[i],totalSong.getOrDefault(genres[i],0) + plays[i]);
            if(!genresSong.containsKey(genres[i])) {
                genresSong.put(genres[i], new ArrayList<>());
            }
            genresSong.get(genres[i]).add(new int[]{i,plays[i]});
        }
        while(!totalSong.isEmpty()){
            int maax = Collections.max(totalSong.values());
            for(String key: totalSong.keySet()) {
                if(totalSong.get(key)==maax) {
                    totalSong.remove(key);
                    ArrayList<int[]> list = genresSong.get(key);
                    Collections.sort(list,(a,b) ->{
                        if(a[1] != b[1]) {
                            return b[1] - a[1];
                        }
                        return a[0] - b[0];
                    });
                    answer.add(list.get(0)[0]);
                    if(list.size()>1) {
                        answer.add(list.get(1)[0]);
                    }
                    break;
                }
            }
        }
        
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}