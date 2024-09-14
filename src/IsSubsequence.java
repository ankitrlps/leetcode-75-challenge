public class IsSubsequence {
    public static void main(String[] args) {
        
    }

    public boolean isSubsequence(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int i = 0;
        int j = 0;
        while (i < sLen && j < tLen) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}
