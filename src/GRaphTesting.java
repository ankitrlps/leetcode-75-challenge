import java.util.ArrayList;
import java.util.List;

public class GRaphTesting {

    public static int minReorder(int n, int[][] connections) {
        List<List<Integer>> al = new ArrayList<>();
        for(int i = 0; i < n; ++i) 
            al.add(new ArrayList<>());
        for (var c : connections) {
            al.get(c[0]).add(c[1]);
            al.get(c[1]).add(-c[0]);
        }
        System.out.println(al);
        return 0;
    }

    public static void main(String[] args) {
        minReorder(6, new int[][]{{0,1},{1,3},{2,3},{4,0},{4,5}});
    }
}
