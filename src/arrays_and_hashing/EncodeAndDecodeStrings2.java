package arrays_and_hashing;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("i");
        list.add("want");
        list.add("this");
        list.add("shit");
        list.add(":");
        list.add("to");
        list.add("work");

        String res = encode(list);

        System.out.println(decode(res));
    }

    public static String encode(List<String> stringList) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String string : stringList) {
            stringBuilder.append(string.length()).append(":").append(string);
        }

        return stringBuilder.toString();
    }

    public static List<String> decode(String string) {
        List<String> list = new ArrayList<>();

        int index = 0;

        while (index < string.length()) {
            StringBuilder stringBuilder = new StringBuilder();

            int innerIndex = index;

            while (string.charAt(innerIndex) != ':') {
                stringBuilder.append(string.charAt(innerIndex));
                innerIndex++;
            }

            int length = Integer.parseInt(stringBuilder.toString());
            String word = string.substring(innerIndex + 1, innerIndex + 1 + length);
            list.add(word);
            index += stringBuilder.length() + 1 + length;
        }

        return list;
    }
}
