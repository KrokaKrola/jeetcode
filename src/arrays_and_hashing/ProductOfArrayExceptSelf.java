package arrays_and_hashing;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] pref = new int[nums.length];
        int[] suf = new int[nums.length];
        int[] result = new int[nums.length];

        int prefMult = 1;
        int sufMult = 1;

        for (int i = 1; i < nums.length; i++) {
            prefMult *= nums[i - 1];
            pref[i] = prefMult;
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            sufMult *= nums[i + 1];
            suf[i] = sufMult;
        }

        for (int i = 0; i < nums.length; i++) {
            int prefValue = i == 0 ? 1 : pref[i];
            int sufValue = i == nums.length - 1 ? 1 : suf[i];
            result[i] = prefValue * sufValue;
        }

        return result;
    }
}
