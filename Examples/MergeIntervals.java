package Examples;

/* Given an array of intervals,merge all overlapping intervals.
Example:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
 */

import java.util.*;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }

        // Sort by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        // Start from second interval
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];

            if (interval[0] <= currentInterval[1]) {
                // Merge overlapping intervals
                currentInterval[1] = Math.max(currentInterval[1], interval[1]);
            } else {
                // No overlap → add new interval
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] mergedIntervals = merge(intervals);

        System.out.println("Merged Intervals:");
        for (int[] interval : mergedIntervals) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }
}
