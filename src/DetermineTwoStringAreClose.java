import java.util.HashMap;
import java.util.Map;

public class DetermineTwoStringAreClose {

    public static boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        if (word1.equals(word2)) return true;
        int len1 = 0;
        int len2 = 0;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();

        for (int i = 0; i < c1.length; i++) {
            int freq1 = map1.getOrDefault(c1[i], 0) + 1;
            map1.put(c1[i], freq1);
            len1 += freq1;

            int freq2 = map2.getOrDefault(c2[i], 0) + 1;
            map2.put(c2[i], freq2);
            len2 += freq2;
        }
        
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            if (!map2.containsKey(entry.getKey())) return false;
        }
        return len1 == len2;
    }
    
    public static void main(String[] args) {
        
    }
}
