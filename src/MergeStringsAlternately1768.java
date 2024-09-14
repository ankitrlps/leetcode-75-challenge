public class MergeStringsAlternately1768 {

    public String mergeAlternately(String word1, String word2) {
        int len = Math.min(word1.length(), word2.length());
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < len) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
            i++;
        }
        if (word1.length() > word2.length()) {
            sb.append(word1.substring(i, word1.length()));
        } else if (word2.length() > word1.length()) {
            sb.append(word2.substring(i, word2.length()));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MergeStringsAlternately1768 alternately1768 = new MergeStringsAlternately1768();
        System.out.println(alternately1768.mergeAlternately("abc", "pqr"));
        System.out.println(alternately1768.mergeAlternately("ab", "pqrs"));
        System.out.println(alternately1768.mergeAlternately("abcd", "pq"));
    }
}
