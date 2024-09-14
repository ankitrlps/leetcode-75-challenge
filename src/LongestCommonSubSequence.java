public class LongestCommonSubSequence {
    
    public static int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0) return 0;
        if (text1.equals(text2)) return text1.length();

        int[][] matrix = new int[text1.length()+1][text2.length()+1];
        char[] ch1 = text1.toCharArray(), ch2 = text2.toCharArray();

        for (int i = matrix.length-2; i >= 0; i--) {
            for (int j = matrix[0].length-2; j >= 0; j--) {
                if (ch1[i] == ch2[j]) {
                    matrix[i][j] = 1 + matrix[i+1][j+1];
                } else {
                    matrix[i][j] = Math.max(matrix[i+1][j], matrix[i][j+1]);
                }
            }
        }

        return matrix[0][0];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }
}
