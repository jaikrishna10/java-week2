import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int a : asteroids) {

            if (a > 0) {
                stack.push(a);
            } 
            else {
                while (!stack.isEmpty() &&
                       stack.peek() > 0 &&
                       stack.peek() < -a) {
                    stack.pop();
                }

                if (!stack.isEmpty() && stack.peek() == -a) {
                    stack.pop();
                }
                else if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(a);
                }
            }
        }

        int[] result = new int[stack.size()];

        for (int i = 0; i < stack.size(); i++) {
            result[i] = stack.get(i);
        }

        return result;
    }
}