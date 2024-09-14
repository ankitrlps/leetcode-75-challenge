import java.util.LinkedList;
import java.util.Queue;

public class NearestExitMaze {

    public static int nearestExit(char[][] maze, int[] entrance) {
        int steps = 0;
        int m = maze.length;
        int n = maze[0].length;
        int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        Queue<int[]> que = new LinkedList<>();
        que.add(entrance);
        maze[entrance[0]][entrance[1]] = '+';

        while (!que.isEmpty()) {
            steps++;
            int k = que.size();
            while (k > 0) {
                int[] curr = que.poll();
                for (int[] direction : directions) {
                    int x = curr[0] + direction[0];
                    int y = curr[1] + direction[1];

                    if (x < 0 || x == m || y < 0 || y == n)
                        continue;

                    if (maze[x][y] == '+')
                        continue;

                    if (x == 0 || x == m - 1 || y == 0 || y == n - 1) {
                        return steps;
                    }

                    que.add(new int[] { x, y });
                    maze[x][y] = '+';

                }
                k--;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(NearestExitMaze.nearestExit(new char[][] {
                { '+', '.', '+', '+', '+', '+', '+' },
                { '+', '.', '+', '.', '.', '.', '+' },
                { '+', '.', '+', '.', '+', '.', '+' },
                { '+', '.', '.', '.', '+', '.', '+' },
                { '+', '+', '+', '+', '+', '.', '+' } }, new int[] { 3, 2 }));

        System.out.println(NearestExitMaze.nearestExit(new char[][] {
                { '+', '+', '+' },
                { '.', '.', '.' },
                { '+', '+', '+' } }, new int[] { 1,0 }));
    }
}
