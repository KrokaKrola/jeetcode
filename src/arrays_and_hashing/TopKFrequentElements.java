package arrays_and_hashing;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(topKFrequent2(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        List<int[]> arr = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            arr.add(new int[]{entry.getKey(), entry.getValue()});
        }

        arr.sort((a, b) -> b[1] - a[1]);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr.get(i)[0];
        }

        return res;
    }

    public static int[] topKFrequent2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
            if (pq.size() > k) {
                pq.poll();
            }
        }


        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = Objects.requireNonNull(pq.poll())[0];
        }

        return res;
    }
}
