// Time Complexity :O(n), where n is the length of the tasks
// Space Complexity : O(1), since there are max 26 characters(constant) only in hashmap
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0) return 0;

        Map<Character, Integer> freqMap = new HashMap<>();

        //check for max frequency of given characters
        int maxFreq = 0;
        for(char task: tasks) {
            freqMap.put(task, freqMap.getOrDefault(task, 0)+1);
            maxFreq = Math.max(maxFreq, freqMap.get(task));
        }

        //check for max count(number of characters with max freq) of max freq
        int maxCount = 0;
        for(char task: freqMap.keySet()) {
            if(freqMap.get(task) == maxFreq) {
                maxCount++;
            }
        }

        //total tasks
        int total = tasks.length;

        //no of partitions
        int partitions = maxFreq - 1;

        //no of empty spaces (partitions * n) available apart from the number of maxCount characters (as they are already filled out)
        int empty = partitions * (n - (maxCount - 1));

        //no of incomplete tasks (total tasks - max freq characters as they are already filled and completed)
        int incompleteTasks = total - (maxFreq * maxCount);

        //no of idle spaces available, if goes negative, assign it to 0
        int idle = Math.max(empty - incompleteTasks, 0);
        return total + idle;
}