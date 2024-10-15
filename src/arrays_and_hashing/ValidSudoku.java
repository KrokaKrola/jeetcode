package arrays_and_hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] boardValid = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(isValidSudoku(boardValid));

        char[][] boardInvalid = {
                {'5', '3', '6', '.', '7', '.', '.', '.', '.'},
                {'6', '8', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(isValidSudoku(boardInvalid));
    }

    public static boolean isValidSudoku(char[][] board) {
        HashMap<String, Set<Character>> boards = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> col = new HashSet<>();

            for (int j = 0; j < board[i].length; j++) {
                String key = Math.floorDiv(i, 3) + "-" + Math.floorDiv(j, 3);

                if (row.contains(board[i][j])) {
                    return false;
                }

                if (col.contains(board[j][i])) {
                    return false;
                }

                if (boards.containsKey(key) && boards.get(key).contains(board[i][j])) {
                    return false;
                }

                if (board[i][j] != '.') {
                    row.add(board[i][j]);

                    if (!boards.containsKey(key)) {
                        boards.put(key, new HashSet<>());
                        boards.get(key).add(board[i][j]);
                    } else {
                        boards.get(key).add(board[i][j]);
                    }
                }

                if (board[j][i] != '.') {
                    col.add(board[j][i]);
                }
            }
        }

        return true;
    }
}
