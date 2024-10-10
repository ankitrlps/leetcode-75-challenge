class MinFlipsToMakeAorBEqualC {

    public static int minFlips(int a, int b, int c) {
        int flips = 0;

        while (a > 0 || b > 0 || c > 0) {
            int right_a = a & 1;
            int right_b = b & 1;
            int right_c = c & 1;

            if (right_c == 0) {
                flips += right_a + right_b; // if 1 and 0 or 0 and 1 or 1 and 1 or 0 and 0, we would need to flips a + b
                                            // times to equal it to c' 0
            } else if (right_a == 0 && right_b == 0) { // this means right_c is 1, so we want to flip once to equal to
                                                       // c's 1
                // any one (right a or right b can be 1)
                flips += 1;
            }
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        return flips;
    }

    public static void main(String[] args) {
        System.out.println(minFlips(2, 6, 5));
        System.out.println(minFlips(8, 3, 5));
        System.out.println(minFlips(4, 2, 7));
    }
}