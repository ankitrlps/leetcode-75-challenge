import java.util.Arrays;

public class EqualRowColumn {
    public static int equalPairs(int[][] grid) {
        int pairs = 0;
        int len = grid.length;
        int i = 0;
        while (i < len) {
            int[] ii = grid[i];
            int k = 0;
            int l = 0;
            int m = 0;
            while (k < len && l < len && m < len) {
                if (ii[k] != grid[k][l]) {
                    m++;
                    l = m;
                    k = 0;
                    continue;
                }
                if (k == len - 1) {
                    pairs++;
                    m++;
                    l = m;
                    k = 0;
                    continue;
                }
                k++;
            }
            i++;
        }
        return pairs;
    }


    public static int equalPairs1(int[][] grid) {
        int pairs = 0;
        int len = grid.length;
        int[][] columns = new int[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                columns[i][j] = grid[j][i];
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (Arrays.equals(columns[j], grid[i])) {
                    pairs++;
                }
            }
        }

        return pairs;
    }
    
    public static void main(String[] args) {
        System.out.println(equalPairs1(new int[][]{{3,2,1},{1,7,6},{2,7,7}}));
    }
}
