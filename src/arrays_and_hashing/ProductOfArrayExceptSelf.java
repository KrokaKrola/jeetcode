package arrays_and_hashing;

import java.util.Arrays;
import java.util.HashMap;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{4, 3, 2, 1, 2})));
    }

    public static int[] productExceptSelf(int[] nums) {
        HashMap<Integer, Integer> pref = new HashMap<>();
        HashMap<Integer, Integer> suf = new HashMap<>();

        int[] result = new int[nums.length];
        int prefMult = 1;
        int sufMult = 1;

        for (int i = 1; i < nums.length; i++) {
            prefMult *= nums[i - 1];
            pref.put(i, prefMult);
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            sufMult *= nums[i + 1];
            suf.put(i, sufMult);
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = pref.getOrDefault(i, 1) * suf.getOrDefault(i, 1);
        }

        return result;
    }
}
