import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class OnlineStockPlan {

    public static void main(String[] args) {

    }
}

class StockSpannerUsingStack {

    private Stack<int[]> prices; // price and spans till that point

    public StockSpannerUsingStack() {
        prices = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        while (prices.size() > 0 && prices.peek()[0] <= price) {
            span += prices.pop()[1];
        }
        prices.push(new int[] { price, span });
        return span;
    }
}

class StockSpannerUsingList {

    private List<Integer> prices;

    public StockSpannerUsingList() {
        prices = new ArrayList<>();
    }

    public int next(int price) {
        int span = 1;
        int len = prices.size() - 1;
        while (len >= 0 && prices.get(len--) <= price) {
            span++;
        }
        prices.add(price);
        return span;
    }
}
