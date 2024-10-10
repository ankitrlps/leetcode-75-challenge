public class CountingBits {

    public static int[] countBits(int n) {
        int[] res = new int[n+1];
        int i = 1;
        while (i <= n) {
            int count = 0;
            if (i % 2 == 1) count++; // checking if current number's remainder is 1
            count += res[i/2]; // adding 1's from previous calculated numbers
            res[i] = count; // saving the total count at current number
            i++;
        }
        return res;
    }
    
    public static int[] countBits1(int n) {
        int[] res = new int[n+1];
        int i = 1;
        while (i <= n) {
            int j = i;
            int count = 0;
            while (j > 0) {
                if (j % 2 == 1) count++;
                j /= 2;
            }
            res[i++] = count;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countBits(2));
        System.out.println(countBits(3));
        System.out.println(countBits(5));
        System.out.println(countBits(6));
        System.out.println(countBits(7));
        System.out.println(6&1);
    }
}
