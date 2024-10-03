public class SmallestInfiniteSet {

    int[] nums;
    int smallest;

    public SmallestInfiniteSet() {
        nums = new int[1001]; // initializing all values with default 0
        smallest = 1;
    }

    public int popSmallest() {
        nums[smallest] = 1; // when the current smallest is popped, mark the value with 1
        int currSmall = smallest;
        while (smallest <= 1000 && nums[smallest] == 1) { // finding the next smallest which isn't 1
            smallest++;
        }
        return currSmall;
    }

    public void addBack(int num) {
        nums[num] = 0; // marking the num index with 0 again
        smallest = Math.min(smallest, num); // picking the smallest again
    }

    public static void main(String[] args) {
        // USING PRIORITY QUEUES

        // private Queue<Integer> que;

        // public SmallestInfiniteSet() {
        //     this.que = new PriorityQueue<>((a, b) -> a - b);
        //     for (int i = 1; i <= 1000; i++) {
        //         this.que.add(i);
        //     }
        // }

        // public int popSmallest() {
        //     return this.que.poll();
        // }

        // public void addBack(int num) {
        //     if (!this.que.contains(num))
        //         this.que.add(num);
        // }
    }
}
