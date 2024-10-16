package daily;

public class SeparateBlackAndWhiteBalls2 {
    public static void main(String[] args) {
        System.out.println(minimumSteps("01010001"));
    }

    public static long minimumSteps(String s) {
        long steps = 0;

        int i = 0, j = 0;

        while (j < s.length()) {
            if (s.charAt(j) == '0') {
                steps += j - i;
                i++;
            }

            j++;
        }

        return steps;
    }
}
