import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(1, new ArrayList<>(), n, k, res);
        return res;
    }

    static void dfs(int index, List<Integer> current, int total, int k, List<List<Integer>> res) {
        if (total == 0 && current.size() == k) {
            res.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i <= 9; i++) {
            current.add(i);
            dfs(i+1, current, total-i, k, res);
            current.remove(current.size()-1);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 9));
        System.out.println(combinationSum3(2, 10));
        System.out.println(combinationSum3(3, 10));
        System.out.println(combinationSum3(3, 7));
    }
}
