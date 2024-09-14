
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Testing {
    public static void main(String[] args) {
        // Map<Integer, Integer> map = new HashMap<>();
        // int d = map.getOrDefault(1, 0) + 1;
        // int[] arr = {4, 4};
        // for (int i : arr) {
            
        // }
        // map.put(1, 12);
        // map.forEach((k, v) -> {
        //     System.out.println(k + " | " + v);
        // });
        // int[] count = new int[256];
        // count['a'] = 1;
        // //System.out.println(count['z']);
        // count['a'] = count['a'] + 1;
        // System.out.println(count['z']);
        // System.out.println(count['a']);
        // System.out.println(count[97]);
        //priorityQueueTesting();
        //System.out.println(intTest(1));
        //testing2DArray();

        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> room1 = new ArrayList<>();
        room1.add(1);
        room1.add(2);
        rooms.add(room1);
        System.out.println(rooms);
        rooms.set(0, null);
        System.out.println(rooms.get(0));
        Map<Integer, String[]> map = new HashMap<>();
        map.put(2, new String[]{"a"});
        char[] ch = new char[]{'a', 'w'};
        int num = 122;
        System.out.println("start");
        System.out.println(num);
        while (num > 0) {
            System.out.println("=====");
            System.out.println(num + " | " + num%10);
            num = num/10;
            System.out.println(num);
        }
    }

    private static int intTest(int i) {
        if (i != 0) {
            if(i == 3) {
                return i;
            } else {
                i++;
                return intTest(i);
            }
        }
        return -1;
    }

    private static void testing2DArray() {
        int[][] arr = {{1,2},{2,3},{3,4},{1,3}};
        Arrays.sort(arr, (a,b) -> Integer.compare(a[0], b[0]));
        System.out.println(arr[0]);
    }

    private static void priorityQueueTesting() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < 3; i++) {
            pq.add(i);
            pq.add(1);
        }
        System.out.println(pq);
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
