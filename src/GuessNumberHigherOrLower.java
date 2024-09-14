public class GuessNumberHigherOrLower {

    static int pick = 5;

    public static void main(String[] args) {
        
    }

    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left)/2;
            int g = guess(mid);
            if (g == 0) {
                return mid;
            } else if (g == -1) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return guess(n) == 0 ? n : -1;
    }

    private static int guess(int num) {
        if (pick == num) return 0; 
        else if (pick < num) return -1;
        else return 1;
    }
}

