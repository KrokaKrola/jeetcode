package two_pointers;

public class ValidPalindrome {
    public static void main(String[] args) {
//        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));

        System.out.println(isPalindrome("0P"));
    }

    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        s = s.toLowerCase();

        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
                continue;
            } else if (!Character.isLetterOrDigit(rightChar)) {
                right--;
                continue;
            }


            if (rightChar != leftChar) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
