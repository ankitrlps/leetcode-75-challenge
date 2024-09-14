public class StringCompression {

    public int compress(char[] chars) {
        int i = 0; // it will stand at a first occurrence char
        int j = 0; // it will run until it finds non equal char on index i
        int k = 0; // it will be used to replace values in chars[]
        while (i < chars.length) {
            while (j < chars.length && chars[j] == chars[i]) {
                j++;
            }
            chars[k] = chars[i]; // updating current index with char itself
            k++;
            if (j - i > 1) {
                String s = String.valueOf(j-i); // converting it to string like "12"
                int a = 0;
                while (a < s.length()) {
                    chars[k] = s.charAt(a);
                    k++;
                    a++;
                }
            }
            i = j;

        }
        return k;
    }

    public int compress1(char[] chars) {
        if (chars.length == 0 || chars == null) return 0;
        StringBuilder sb = new StringBuilder();
        //Arrays.sort(chars);
        char runner = chars[0];
        int i = 0;
        for (int j = 0; j < chars.length; j++) {
            if (chars[j] != runner) {
                if (j-i == 1) {
                    sb.append(Character.toString(runner));
                } else {
                    sb.append(Character.toString(runner) + (j-i));
                }
                runner = chars[j];
                i = j;
            }
            if (j == chars.length-1) {
                if (j-i+1 == 1) {
                    sb.append(Character.toString(chars[j]));
                } else {
                    sb.append(Character.toString(chars[j]) + (j-i+1));
                }
            }
        }
        String s = sb.toString();
        for (int a = 0; a < s.length(); a++) {
            chars[a] = s.charAt(a);
        }
        
        return s.length();
    }
    
    public static void main(String[] args) {
        
    }
}
