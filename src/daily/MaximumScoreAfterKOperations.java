package daily;

import java.util.Objects;
import java.util.PriorityQueue;

public class MaximumScoreAfterKOperations {
    public static void main(String[] args) {
        System.out.println(maxKelements(new int[]{1, 10, 3, 3, 3}, 3));
    }

    public static long maxKelements(int[] nums, int k) {
        long score = 0L;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int num : nums) {
            maxHeap.add(num);
        }

        int operationsDone = 0;

        while (operationsDone < k) {
            int maxItem = Objects.requireNonNull(maxHeap.poll());
            score += maxItem;
            maxItem = Math.ceilDiv(maxItem, 3);
            maxHeap.add(maxItem);
            operationsDone++;
        }

        return score;
    }
}
