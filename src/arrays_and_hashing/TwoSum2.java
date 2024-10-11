package arrays_and_hashing;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum1(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum1(new int[]{3,3}, 6)));

        System.out.println(Arrays.toString(twoSum2(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum2(new int[]{3,3}, 6)));
    }

    public static int[] twoSum1(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
        }

        return new int[]{};
    }

    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
