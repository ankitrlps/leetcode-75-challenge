import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurrences {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            int count = map.getOrDefault(i, 0);
            map.put(i, count + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (!set.add(entry.getValue()))
                return false;
        }
        return true;
    }

    public boolean uniqueOccurrences1(int[] arr) {
        Arrays.sort(arr);
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] != arr[i-1]) {
                if (set.add(count) == false){
                    return false;
                }
                count = 1;
                continue;
            }
            count++;
        }
        return set.add(count);
    }

    public static void main(String[] args) {

    }
}
