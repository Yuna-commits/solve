import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        for(String op : operations) {
            String[] split = op.split(" ");
            
            switch(split[0]) {
                case "I":
                    int value = Integer.parseInt(split[1]);
                    treeMap.put(value, treeMap.getOrDefault(value, 0) + 1);
                    break;
                case "D":
                    if(treeMap.isEmpty()) {
                        continue;
                    }
                    
                    int delete = 0;
                    
                    switch(split[1]) {
                        case "1":
                            delete = treeMap.lastKey();
                            break;
                        case "-1":
                            delete = treeMap.firstKey();
                            break;
                    }
                                
                    if(treeMap.get(delete) > 1) {
                        treeMap.put(delete, treeMap.get(delete) - 1);
                    } else {
                        treeMap.remove(delete);
                    }
                    
                    break;
            }
        }
        
        return (treeMap.isEmpty() 
                ? new int[] {0, 0} 
                : new int[] {treeMap.lastKey(), treeMap.firstKey()});
    }
}