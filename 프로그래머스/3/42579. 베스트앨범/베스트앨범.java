import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {     
        // <장르, 재생수 합>
        Map<String, Integer> playMap = new HashMap<>();
        
        // <장르, 곡[번호, 재생수] 리스트>
        Map<String, List<int[]>> genreMap = new HashMap<>();
        
        // 데이터 저장
        for(int i=0; i<genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            playMap.put(genre, playMap.getOrDefault(genre, 0) + play);
            // 키가 있으면 기존 리스트에 번호 추가, 없으면 새로 생성 후 [번호, 재생수] 추가
            genreMap.computeIfAbsent(genre, k -> new ArrayList<>()).add(new int[]{i, play});
        }

        // 장르를 총 재생수 기준 내림차순 정렬
        List<String> sortedGenre = new ArrayList<>(playMap.keySet());
        sortedGenre.sort((o1, o2) -> playMap.get(o2).compareTo(playMap.get(o1)));
        
        List<Integer> answer = new ArrayList<>();
        
        // 각 장르의 곡을 재생수 기준 내림차순 정렬, 고유번호 기준 오름차순 정렬
        for(String g : sortedGenre) {
            // 장르별 [번호, 재생수] 목록
            List<int[]> sortedSongs = genreMap.get(g);
            
            sortedSongs.sort((o1, o2) -> {
                if(o2[1] != o1[1]) {
                    return Integer.compare(o2[1], o1[1]);
                } 
                
                return Integer.compare(o1[0], o2[0]);
            });
            
            // 정렬된 곡의 고유번호 추가 (곡이 1개인 경우는 한 개만 추가)
            for(int i=0; i<Math.min(2, sortedSongs.size()); i++) {
                answer.add(sortedSongs.get(i)[0]);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}