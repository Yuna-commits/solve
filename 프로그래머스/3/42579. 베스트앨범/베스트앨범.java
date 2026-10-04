import java.util.*;

class Solution {
    
    // 노래 정보를 관리하는 클래스
    static class Music implements Comparable<Music> {
        int id;
        int play;
        String genre;
        
        public Music(int id, int play, String genre) {
            this.id = id;
            this.play = play;
            this.genre = genre;
        }
        
        @Override
        public int compareTo(Music other) {
            // 재생 횟수가 다르면 내림차순
            if (this.play != other.play) {
                return Integer.compare(other.play, this.play);
            }
            // 재생 횟수가 같으면 오름차순
            return Integer.compare(this.id, other.id);
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> playMap = new HashMap<>();
        Map<String, List<Music>> genreMusicMap = new HashMap<>();
        
        // 데이터 저장
        for(int i=0; i<genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            playMap.put(genre, playMap.getOrDefault(genre, 0) + play);
            
            genreMusicMap.computeIfAbsent(genre, k -> new ArrayList<>()).add(new Music(i, play, genre));
        }
        
        // 장르를 총 재생수 기준으로 내림차순 정렬
        List<String> sortedGenre = new ArrayList<>(playMap.keySet());
        sortedGenre.sort((g1, g2) -> playMap.get(g2).compareTo(playMap.get(g1)));
        
        List<Integer> answer = new ArrayList<>();
        
        // 장르별로 곡 정렬 1. 재생수 내림차순 2. 고유번호 오름차순
        for(String g : sortedGenre) {
            List<Music> musicList = genreMusicMap.get(g);
            Collections.sort(musicList);
            
            // 장르별 최대 2곡 고유번호 추가 (곡이 1개인 경우는 한 개만 추가)
            for(int i=0; i<Math.min(2, musicList.size()); i++) {
                answer.add(musicList.get(i).id);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}