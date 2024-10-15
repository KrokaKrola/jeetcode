package daily;

public class SeparateBlackAndWhiteBalls {
    public static void main(String[] args) {
//        System.out.println(minimumSteps("101"));
//        System.out.println(minimumSteps("100"));
//        System.out.println(minimumSteps("0111"));
//        System.out.println(minimumSteps("11000111"));
        System.out.println(minimumSteps("01010001"));
    }

    public static long minimumSteps(String s) {
        long steps = 0;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            if (s.charAt(r) == '0') {
                steps += r - l;
                l += 1;
            }
        }

        return steps;
    }
}
