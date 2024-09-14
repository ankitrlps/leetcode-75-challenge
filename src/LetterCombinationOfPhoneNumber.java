import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfPhoneNumber {
    
    public static void main(String[] args) {
        System.out.println(LetterCombinationOfPhoneNumber.letterCombinations1("23"));
    }


    public static List<String> letterCombinations1(String digits) {
        int len = digits.length();
        List<String> result = new ArrayList<>();
        if (len == 0) return result;

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        backtrack(0, new StringBuilder(), map, digits, result);
        return result;
    }

    private static void backtrack(int index, StringBuilder sb, Map<Character, String> map, String digits, List<String> result) {
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }
        String letters = map.get(digits.charAt(index));
        for (char ch : letters.toCharArray()) {
            sb.append(ch);
            backtrack(index + 1, sb, map, digits, result);
            sb.deleteCharAt(sb.length()-1);
        }
    }


    public List<String> letterCombinations(String digits) {
        int len = digits.length();
        if (len == 0) return new ArrayList<>();
        Map<String, String[]> map = new HashMap<>();
        map.put("2", new String[]{"a", "b", "c"});
        map.put("3", new String[]{"d", "e", "f"});
        map.put("4", new String[]{"g", "h", "i"});
        map.put("5", new String[]{"j", "k", "l"});
        map.put("6", new String[]{"m", "n", "o"});
        map.put("7", new String[]{"p", "q", "r", "s"});
        map.put("8", new String[]{"t", "u", "v"});
        map.put("9", new String[]{"w", "x", "y", "z"});
        if (len == 1) return Arrays.asList(map.get(digits));

        List<String> result = new ArrayList<>();
        
        String[] digitOne = map.get(digits.substring(0, 1));
        for (int i = 0; i < digitOne.length; i++) {
            String[] digitTwo = map.get(digits.substring(1, 2));
            for (int j = 0; j < digitTwo.length; j++) {
                if (len >= 3) {
                    String[] digitThree = map.get(digits.substring(2, 3));
                    for (int k = 0; k < digitThree.length; k++) {
                        if (len == 4) {
                            String[] digitFour = map.get(digits.substring(3, 4));
                            for (int l = 0; l < digitFour.length; l++) {
                                result.add(digitOne[i] + digitTwo[j] + digitThree[k] + digitFour[l]);    
                            }
                        } else {
                            result.add(digitOne[i] + digitTwo[j] + digitThree[k]);
                        }
                    }
                } else {
                    result.add(digitOne[i] + digitTwo[j]);
                }
            }
        }
        return result;
    }
}
