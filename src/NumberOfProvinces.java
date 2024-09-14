public class NumberOfProvinces {

    public int findCircleNum(int[][] isConnected) {
        int provinces = 0;
        boolean[] visited = new boolean[isConnected.length];
        for (int start = 0; start < isConnected.length; start++) {
            if (!visited[start]) {
                provinces++;
                dfs(start, isConnected, visited);
            }
        }
        return provinces;
    }

    private void dfs(int start, int[][] isConnected, boolean[] visited) {
        visited[start] = true;
        for (int end = 0; end < isConnected.length; end++) {
            if (isConnected[start][end] == 1 && !visited[end]) {
                dfs(end, isConnected, visited);
            }
        }
    }


    public static void main(String[] args) {
        
    }
}
