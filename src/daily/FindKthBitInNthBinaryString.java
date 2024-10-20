package daily;

public class FindKthBitInNthBinaryString {
    public static void main(String[] args) {
        System.out.println(findKthBit(3, 1));
    }

    public static String invert(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                sb.append("0");
            } else if (s.charAt(i) == '0') {
                sb.append("1");
            }
        }

        return sb.toString();
    }

    public static String reverse(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }

    public static char findKthBit(int n, int k) {
        String[] arr = new String[n];

        arr[0] = "0";

        for (int i = 1; i <= n - 1; i++) {
            String prevItem = arr[i - 1];
            arr[i] = prevItem + "1" + reverse(invert(prevItem));
        }

        return arr[n - 1].charAt(k - 1);
    }
}
