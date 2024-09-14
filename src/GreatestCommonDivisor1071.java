public class GreatestCommonDivisor1071 {

    /*
     * https://leetcode.com/problems/greatest-common-divisor-of-strings
     */

    public String gcdOfStrings(String str1, String str2) {
        if (str2.length() > str1.length()) return gcdOfStrings(str2, str1);

        if (str1.equals(str2)) return str1;

        if (str1.startsWith(str2)) return gcdOfStrings(str1.substring(str2.length()), str2);
        return "";
    }
    
    public static void main(String[] args) {
        GreatestCommonDivisor1071 commonDivisor1071 = new GreatestCommonDivisor1071();
        System.out.println(commonDivisor1071.gcdOfStrings("ABCABC", "ABC"));
        System.out.println(commonDivisor1071.gcdOfStrings("ABABAB", "ABAB"));
        System.out.println(commonDivisor1071.gcdOfStrings("LEET", "CODE"));
        
    }
}
