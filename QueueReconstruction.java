// Time Complexity :  O(n log n) (sorting) + O(n^2) (insertion) = O (n^2)
// Space Complexity : O(n) to keep the output
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class QueueReconstruction {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> resultList = new ArrayList<>();


        // first index - element
        // second index - number of elements (that are larger than/ equal to the current element) that can be in front of this element
        //Sort the array such that first indices are sorted in descending order,
        //if first indices are equal, sort the second index in ascending order
        Arrays.sort(people, (a, b) -> {
            if(a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        //Insertion at right position based on the number of elements that are greater than the current element that can be in front of this element
        //second index represents the position of the element in the result list
        for(int[] person: people) {
            resultList.add(person[1], person);
        }
        return resultList.toArray(new int[0][]);
    }
}