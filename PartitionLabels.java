// Time Complexity : O(2n) = O(n), where n is the length of the string
// Space Complexity : O(1) since there are max 26 characters(constant) only in hashmap
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        //Base case
        if(s == null || s.length() == 0) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        //Record the last occurrence of each character in a string
        Map<Character, Integer> lastCharMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            lastCharMap.put(s.charAt(i), i);
        }

        //Form partitions
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int lastCharIndex = lastCharMap.get(c);
            //Update end if the last character index is greater than the current end
            if(lastCharIndex > end) end = lastCharIndex;

            //If the end is reached, add the difference to the result and start the next partition
            if(i == end) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }
}