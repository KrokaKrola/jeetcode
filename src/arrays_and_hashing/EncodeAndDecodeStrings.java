package arrays_and_hashing;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("we");
        list.add("say");
        list.add(":");
        list.add("yes");

        String encodedString = encode(list);
        List<String> decodedString = decode(encodedString);

        System.out.println(decodedString);
    }

    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str.length()).append("$").append(str);
        }

        return sb.toString();
    }

    public static List<String> decode(String str) {
        List<String> list = new ArrayList<>();

        int i = 0;

        while (i < str.length()) {
            int j = i;

            while (str.charAt(j) != '$') {
                j++;
            }

            int strLength = Integer.parseInt(str.substring(i, j));
            i = j + 1 + strLength;
            list.add(str.substring(j + 1, i));
        }

        return list;
    }
}
