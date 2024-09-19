import java.util.Stack;

public class DailyTemperature {

    static class Pair {
        private int temp;
        private int index;
        public Pair(int temp, int index) {
            this.temp = temp;
            this.index = index;
        }
        int getTemp() {
            return this.temp;
        }
        int getIndex() {
            return this.index;
        }
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair> stack = new Stack<>();
        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (stack.size() > 0 && stack.peek().getTemp() < temperatures[i]) {
                Pair temp = stack.pop();
                res[temp.getIndex()] = i - temp.getIndex();
            }

            stack.push(new Pair(temperatures[i], i));
        }
        return res;
    }
    
    public static void main(String[] args) {
        
    }
}
