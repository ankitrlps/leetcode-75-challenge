import java.util.Arrays;
import java.util.Stack;

public class AstroidCollision {
    
    public static void main(String[] args) {
        AstroidCollision astroidCollision = new AstroidCollision();
        System.out.println(Arrays.toString(astroidCollision.asteroidCollision1(new int[]{5,10,-5})));
        System.out.println(Arrays.toString(astroidCollision.asteroidCollision1(new int[]{8,-8})));
        System.out.println(Arrays.toString(astroidCollision.asteroidCollision1(new int[]{10,2,-5})));
        System.out.println(Arrays.toString(astroidCollision.asteroidCollision1(new int[]{5,10,-5,10,2,-5})));
        System.out.println(Arrays.toString(astroidCollision.asteroidCollision1(new int[]{5,10,-15,10,2,-5,-6})));
        System.out.println(Arrays.toString(astroidCollision.asteroidCollision1(new int[]{-2,-1,1,2})));
        System.out.println(Arrays.toString(astroidCollision.asteroidCollision1(new int[]{-2,-2,1,-2})));
        System.out.println(Arrays.toString(astroidCollision.asteroidCollision1(new int[]{1,-2,-2,-2})));
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int currAst : asteroids) {
            if (stack.size() > 0 && stack.peek() > 0 && currAst < 0) {
                while (stack.size() > 0 && stack.peek() > 0 && (Math.abs(stack.peek()) < Math.abs(currAst))) {
                    stack.pop();
                }
                if (stack.size() > 0 && stack.peek() > 0 && Math.abs(stack.peek()) == Math.abs(currAst)) {
                    stack.pop();
                    continue;
                } else if (stack.size() > 0 && stack.peek() > Math.abs(currAst)) {
                    continue;
                } else {
                    stack.push(currAst);
                }
            } else {
                stack.push(currAst);
            }
        }
        int size = stack.size();
        int[] res = new int[size];
        int k = size - 1;
        while (k >= 0) {
            res[k] = stack.pop();
            k--;
        }
        return res;
    }



    public int[] asteroidCollision1(int[] asteroids) {
        //first - find if it will collide based on sign
        //second - if it will collide, loop through stack and remove the ones
        Stack<Integer> stack = new Stack<>();
        stack.push(asteroids[0]);
        int i = 1;
        while (i < asteroids.length && stack.size() > 0) {
            if (willCollide(stack.peek(), asteroids[i])) {
                while (stack.size() > 0) {
                    if (!willCollide(stack.peek(), asteroids[i])) {
                        stack.push(asteroids[i]);
                        break;
                    }
                    if (Math.abs(stack.peek()) < Math.abs(asteroids[i])) {
                        stack.pop();
                    } else if (Math.abs(stack.peek()) == Math.abs(asteroids[i])) {
                        stack.pop();
                        i++;
                        break;
                    } else {
                        break;
                    }
                }
                if (stack.isEmpty() && i < asteroids.length) stack.push(asteroids[i]);
                // if (!stack.isEmpty() && i < asteroids.length && !willCollide(stack.peek(), asteroids[i])) {
                //     stack.push(asteroids[i]);
                // }
            } else {
                stack.push(asteroids[i]);
            }
            i++;
        }



        int[] res = new int[stack.size()];
        int j = stack.size()-1;
        while (stack.size() > 0) {
            res[j--] = stack.pop();
        }

        return res;
    }

    private boolean willCollide(int x, int y) {
        return x > 0 && y < 0;
    }

}
