package daily;

public class CountNumberOfMaxBitwiseOrSubsets {
    public static void main(String[] args) {
        System.out.println(countMaxOrSubsets(new int[]{3, 1}));
        System.out.println(countMaxOrSubsets(new int[]{2, 2, 2}));
        System.out.println(countMaxOrSubsets(new int[]{3, 2, 1, 5}));
    }

    public static int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;

        for (int num : nums) {
            maxOr |= num;
        }

        return countSubsets(nums, 0, 0, maxOr);
    }

    private static int countSubsets(
            int[] nums,
            int index,
            int currentOr,
            int targetOr
    ) {
        // Base case: reached the end of the array
        if (index == nums.length) {
            return (currentOr == targetOr) ? 1 : 0;
        }

        // Don't include the current number
        int countWithout = countSubsets(nums, index + 1, currentOr, targetOr);

        // Include the current number
        int countWith = countSubsets(
                nums,
                index + 1,
                currentOr | nums[index],
                targetOr
        );

        // Return the sum of both cases
        return countWithout + countWith;
    }
}
