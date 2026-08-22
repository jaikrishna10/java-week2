import java.util.*;

class Solution {
    public String minRemoveToMakeValid(String s) {

        Stack<Integer> stack = new Stack<>();
        boolean[] remove = new boolean[s.length()];

        // First pass
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            else if (s.charAt(i) == ')') {

                if (!stack.isEmpty()) {
                    stack.pop();
                }
                else {
                    remove[i] = true;
                }
            }
        }

        // Unmatched '('
        while (!stack.isEmpty()) {
            remove[stack.pop()] = true;
        }

        // Build answer
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (!remove[i]) {
                ans.append(s.charAt(i));
            }
        }

        return ans.toString();
    }
}