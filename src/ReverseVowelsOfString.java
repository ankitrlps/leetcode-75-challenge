import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * https://leetcode.com/problems/reverse-vowels-of-a-string/description/
 */
public class ReverseVowelsOfString {

    public String reverseVowels1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('e', 0);
        map.put('i', 0);
        map.put('o', 0);
        map.put('u', 0);
        char[] ch = s.toCharArray();
        int i = 0;
        int j = ch.length-1;
        while (i < j) {
            char ci = Character.toLowerCase(ch[i]);
            char cj = Character.toLowerCase(ch[j]);
            if (map.containsKey(ci) && !map.containsKey(cj)) {
                j--;
            } else if (!map.containsKey(ci) && map.containsKey(cj)) {
                i++;
            } else if (map.containsKey(ci) && map.containsKey(cj)) {
                char temp = ch[i];
                ch[i] = ch[j];
                ch[j] = temp;
                i++;
                j--;
            } else {
                i++;
                j--;
            }
        }
        return String.valueOf(ch);
    }

    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('A');
        set.add('e');
        set.add('E');
        set.add('i');
        set.add('I');
        set.add('o');
        set.add('O');
        set.add('u');
        set.add('U');
        int i = 0;
        int j = s.length()-1;
        char[] ch = s.toCharArray();
        while (i < j) {
            boolean b1 = set.contains(ch[i]);
            boolean b2 = set.contains(ch[j]);
            if (!b1) {
                i++;
            }
            if (!b2) {
                j--;
            }
            if (b1 == true && b2 == true) {
                char temp = ch[i];
                ch[i] = ch[j];
                ch[j] = temp;
                i++;
                j--;
            }
        }
        return String.valueOf(ch);
    }

    public static void main(String[] args) {
        ReverseVowelsOfString ofString = new ReverseVowelsOfString();
        ofString.reverseVowels("hello");
        ofString.reverseVowels("leetcode");
    }
}
