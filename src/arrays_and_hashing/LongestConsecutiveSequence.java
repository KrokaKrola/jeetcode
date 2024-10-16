package arrays_and_hashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int key : set) {
            int len = 1;

            if (!set.contains(key - 1)) {
                while (set.contains(key + len)) {
                    len++;
                }

                longest = Math.max(longest, len);
            }
        }

        return longest;
    }
}
