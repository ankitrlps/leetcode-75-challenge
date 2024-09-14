import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetermineTwoStringsAreClose {
    
    public static void main(String[] args) {
        DetermineTwoStringsAreClose testing1 = new DetermineTwoStringsAreClose();
        System.out.println(testing1.closeStrings("abbzzca", "babzzcz"));
        System.out.println(testing1.closeStrings("uau", "ssx"));
        System.out.println(testing1.closeStrings("cabbba", "ssx"));
    }

    private boolean closeStringsAnotherSolution(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;

        Map<Character, Integer> map1 = new HashMap<>();
        
        for (int i = 0; i < word1.length(); i++) {
            char ch = word1.charAt(i);
            if (map1.containsKey(ch)) {
                map1.put(ch, map1.get(ch) + 1);
            } else {
                map1.put(ch, 1);
            }
        }

        Map<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < word2.length(); i++) {
            char ch = word2.charAt(i);
            if (map2.containsKey(ch)) {
                map2.put(ch, map2.get(ch) + 1);
            } else {
                map2.put(ch, 1);
            }
        }

        List<Integer> freq = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            if (!map2.containsKey(entry.getKey())) {
                return false;
            }
            freq.add(entry.getValue());
        }

        for (Map.Entry<Character, Integer> entry : map2.entrySet()) {
            if (!freq.contains(entry.getValue())) {
                return false;
            }
        }

        return true;
    }


    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (char ch : word1.toCharArray()) {
            freq1[ch - 'a']++;
        }

        for (char ch : word2.toCharArray()) {
            freq2[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if ((freq1[i] != 0 && freq2[i] == 0) || (freq1[i] == 0 && freq2[i] != 0)) {
                return false;
            }
        }

        Arrays.sort(freq1);
        Arrays.sort(freq2);

        int i = 0;
        while (i < 26) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
            i++;
        }

        return true;
    }
}
