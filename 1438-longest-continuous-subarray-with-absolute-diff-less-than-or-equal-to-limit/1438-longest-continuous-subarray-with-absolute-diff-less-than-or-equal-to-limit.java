import java.util.*;

class Solution {
    public int longestSubarray(int[] nums, int limit) {

        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();

        int left = 0;
        int answer = 0;

        for (int right = 0; right < nums.length; right++) {

            // Keep maximum values in decreasing order
            while (!maxDeque.isEmpty() &&
                   nums[maxDeque.peekLast()] < nums[right]) {
                maxDeque.pollLast();
            }

            // Keep minimum values in increasing order
            while (!minDeque.isEmpty() &&
                   nums[minDeque.peekLast()] > nums[right]) {
                minDeque.pollLast();
            }

            maxDeque.offerLast(right);
            minDeque.offerLast(right);

            // If difference is greater than limit,
            // move left forward
            while (nums[maxDeque.peekFirst()]
                   - nums[minDeque.peekFirst()] > limit) {

                if (maxDeque.peekFirst() == left) {
                    maxDeque.pollFirst();
                }

                if (minDeque.peekFirst() == left) {
                    minDeque.pollFirst();
                }

                left++;
            }

            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }
}