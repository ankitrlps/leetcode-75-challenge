public class NthTribonacciNumber {
    public static void main(String[] args) {
        
    }

    public int tribonacci(int n) {
        int[] f = new int[38];
        f[0] = 0;
        f[1] = 1;
        f[2] = 1;
        if (n <= 2) return f[n];
        for (int i = 0; i <= n; i++) {
            f[i+3] = f[i] + f[i+1] + f[i+2];
            if (i+3 == n) return f[i+3];
        }
        return 0;
    }
}
