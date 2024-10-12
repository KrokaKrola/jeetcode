package arrays_and_hashing;

import java.util.*;

public class TopKFrequentElements2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }

    public static int[] topKFrequent(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int item : arr) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.offer(entry);

            System.out.println(minHeap);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = Objects.requireNonNull(minHeap.poll()).getKey();
        }

        return result;
    }
}
