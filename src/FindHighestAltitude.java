public class FindHighestAltitude {
    public static void main(String[] args) {
        FindHighestAltitude altitude = new FindHighestAltitude();
        System.out.println(altitude.largestAltitude(new int[]{-5,1,5,0,-7}));
        System.out.println(altitude.largestAltitude(new int[]{-4,-3,-2,-1,4,3,2}));
    }

    public int largestAltitude(int[] gain) {
        int alt = 0;
        int max = 0;
        for (int i : gain) {
            alt = alt + i;
            max = Math.max(max, alt);
        }
        return max;
    }
}
