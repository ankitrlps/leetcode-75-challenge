public class MaximumNumberOfVowels {

    public static int maxVowels(String s, int k) {
        int max = 0;
        char[] ch = s.toCharArray();
        int i = 0;
        int j = 0;
        int count = 0;
        while (j < k) {
            if (isVowel(ch[j])) {
                count++;
            }
            j++;
        }
        max = Math.max(max, count);

        i = 1;
        while (j < ch.length && j - i + 1 <= k) {
            if (isVowel(ch[j])) {
                count++;
            }
            if (isVowel(ch[i - 1])) {
                    count--;
            }
            max = Math.max(max, count);
            i++;
            j++;
        }
        return max;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'; 
    }
    
    public static void main(String[] args) {
        System.out.println(maxVowels("leetcode", 3));
        System.out.println(maxVowels("abciiidef", 3));
        System.out.println(maxVowels("aeiou", 2));
        System.out.println(maxVowels("weallloveyou", 7));
    }
}
