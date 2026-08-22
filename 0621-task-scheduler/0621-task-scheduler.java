class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] count = new int[26];

        // Count frequency of each task
        for (char c : tasks) {
            count[c - 'A']++;
        }

        // Find maximum frequency
        int maxFreq = 0;

        for (int freq : count) {
            maxFreq = Math.max(maxFreq, freq);
        }

        // Count how many tasks have maximum frequency
        int maxCount = 0;

        for (int freq : count) {
            if (freq == maxFreq) {
                maxCount++;
            }
        }

        // Calculate minimum intervals
        int result = (maxFreq - 1) * (n + 1) + maxCount;

        return Math.max(tasks.length, result);
    }
}