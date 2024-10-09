public class UniquePaths {

    public static int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];
        
        //starting from bottom
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (i == m-1 || j == n-1) { // last row and last column will always be 1 
                    paths[i][j] = 1; //because the corresponding row or col will be out of index so will be treated as 0
                } else {
                    paths[i][j] = paths[i+1][j] + paths[i][j+1];
                }
            }
        }

        return paths[0][0];
    }
    
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
        System.out.println(uniquePaths(3, 2));
        System.out.println(uniquePaths(23, 12));
    }
}
