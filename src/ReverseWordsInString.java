public class ReverseWordsInString {

    public String reverseWords(String s) {
        char[] ch = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = s.length()-1;
        while (i >= 0) {
            if (ch[i] != ' ') {
                int j = i;
                while (i >= 0 && ch[i] != ' ') {
                    i--;
                }
                sb.append(s.substring(i+1, j+1) + " ");
            }
            i--;
        }
        return sb.substring(0, sb.length()-1);
    }
    
    public String reverseWords2(String s) {
        String cleanString = "";
        boolean wordRunning = false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!Character.isWhitespace(ch)) {
                wordRunning = true;
                cleanString += ch;
            } else {
                if (wordRunning) {
                    cleanString += " ";
                    wordRunning = false;
                }
            }
        }

        String[] sArr = cleanString.split(" ");
        String result = "";
        for (int j = sArr.length-1; j >= 0; j--) {
            result += sArr[j];
            if (j != 0) {
                result += " ";
            }
        }
        return result;
    }

    public String reverseWords1(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.trim();
        String[] arr = s.split("\\s+");
        for (int i = arr.length-1; i >= 0; i--) {
            sb.append(arr[i] + " ");
        }
        return sb.toString().trim();
    }
    
    public static void main(String[] args) {
        String s = "a good   example";
        ReverseWordsInString inString = new ReverseWordsInString();
        inString.reverseWords(s);
    }
}
