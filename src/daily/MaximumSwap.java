package daily;

import java.util.ArrayList;

public class MaximumSwap {
    public static void main(String[] args) {
        System.out.println(maximumSwap(1993));
  /*      System.out.println(maximumSwap(2736));
        System.out.println(maximumSwap(9973));
        System.out.println(maximumSwap(9937));
        System.out.println(maximumSwap(10));*/
    }

    public static int maximumSwap(int num) {
        char[] str = String.valueOf(num).toCharArray();

        // Store the last occurrence of each digit (0-9)
        int[] last = new int[10];

        // Populate the last occurrence of each digit
        for (int i = 0; i < str.length; i++) {
            last[str[i] - '0'] = i;
        }

        // Iterate through the number to find the first swap opportunity
        for (int i = 0; i < str.length; i++) {
            // Check for any larger digit that occurs later in the number
            for (int d = 9; d > str[i] - '0'; d--) {
                if (last[d] > i) {
                    // Swap current digit with the last occurrence of this larger digit
                    char temp = str[i];
                    str[i] = str[last[d]];
                    str[last[d]] = temp;

                    // Return the new maximum number
                    return Integer.parseInt(new String(str));
                }
            }
        }

        // If no swap was made, return the original number
        return num;
    }
}
