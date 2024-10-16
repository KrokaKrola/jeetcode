package daily;

import java.util.HashMap;
import java.util.PriorityQueue;

public class LongestHappyString {
    public static void main(String[] args) {
        System.out.println(longestDiverseString3(7, 1, 0));
    }

    public static String longestDiverseString(int a, int b, int c) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('a', a);
        map.put('b', b);
        map.put('c', c);

        StringBuilder sb = new StringBuilder();

        int cConsecutive = 0;
        int bConsecutive = 0;
        int aConsecutive = 0;

        while (true) {
            int nextCharCount = 0;
            char ch = 0;

            for (Character character : map.keySet()) {
                int val = map.get(character);

                if (character == 'a' && aConsecutive == 2) {
                    continue;
                }

                if (character == 'b' && bConsecutive == 2) {
                    continue;
                }

                if (character == 'c' && cConsecutive == 2) {
                    continue;
                }

                if (val > nextCharCount) {
                    nextCharCount = val;
                    ch = character;
                }
            }

            if (nextCharCount == 0) {
                break;
            }

            if (ch == 'a') {
                aConsecutive++;
                bConsecutive = 0;
                cConsecutive = 0;
            } else if (ch == 'b') {
                bConsecutive++;
                aConsecutive = 0;
                cConsecutive = 0;
            } else if (ch == 'c') {
                cConsecutive++;
                aConsecutive = 0;
                bConsecutive = 0;
            }

            map.put(ch, map.get(ch) - 1);
            sb.append(ch);
        }

        return sb.toString();
    }

    public static String longestDiverseString2(int a, int b, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> a2[0] - a1[0]);
        pq.offer(new int[]{a, 'a'});
        pq.offer(new int[]{b, 'b'});
        pq.offer(new int[]{c, 'c'});

        StringBuilder sb = new StringBuilder();

        int[] last = new int[]{0, '0'};

        while (!pq.isEmpty()) {
            int[] el = pq.poll();

            if (el[0] == 0) {
                continue;
            }

            if (last[1] == '0') {
                sb.append(Character.toString(el[1]));
                last[0] = 1;
                last[1] = el[1];
                el[0]--;
            } else if (el[1] == last[1] && last[0] == 2) {
                if (pq.isEmpty()) {
                    break;
                }

                int[] nextEl = pq.poll();

                if (nextEl[0] == 0) {
                    break;
                }

                sb.append(Character.toString(nextEl[1]));
                nextEl[0]--;

                if (nextEl[0] > 0) {
                    pq.offer(nextEl);
                }

                last[0] = 1;
                last[1] = nextEl[1];
            } else {
                sb.append(Character.toString(el[1]));

                if (el[1] == last[1]) {
                    last[0]++;
                }

                last[1] = el[1];
                el[0]--;
            }

            if (el[0] > 0) {
                pq.offer(el);
            }
        }

        return sb.toString();
    }

    public static String longestDiverseString3(int a, int b, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> a2[0] - a1[0]);
        if (a > 0) {
            pq.offer(new int[]{a, 'a'});
        }
        if (b > 0) {
            pq.offer(new int[]{b, 'b'});
        }
        if (c > 0) {
            pq.offer(new int[]{c, 'c'});
        }

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            int[] el = pq.poll();

            if (sb.length() > 1 && sb.charAt(sb.length() - 1) == el[1] && sb.charAt(sb.length() - 2) == el[1]) {
                if (pq.isEmpty()) {
                    break;
                }

                int[] nextEl = pq.poll();
                sb.append(Character.toString(nextEl[1]));
                nextEl[0]--;

                if (nextEl[0] > 0) {
                    pq.offer(nextEl);
                }

                pq.offer(el);
            } else {
                sb.append(Character.toString(el[1]));
                el[0]--;

                if (el[0] > 0) {
                    pq.offer(el);
                }
            }
        }

        return sb.toString();
    }
}
