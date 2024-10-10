package arrays_and_hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] arrNoDuplicates = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arrDuplicates = {2, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        boolean res = containsDuplicate3(arrNoDuplicates);
        System.out.println(res);
    }

    /**
     * Solution using HashMap
     * <p>
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                return true;
            }

            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return false;
    }

    /**
     * Solution using HashSet
     * <p>
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public static boolean containsDuplicate2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }

            set.add(num);
        }

        return false;
    }

    /**
     * Solution using array sorting before processing array
     * <p>
     * Time complexity: O(log(n))
     * Space complexity: O(n)
     */
    public static boolean containsDuplicate3(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }

        return false;
    }
}
