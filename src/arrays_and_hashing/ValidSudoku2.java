package arrays_and_hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ValidSudoku2 {
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
        HashMap<String, List<Character>> subgrids = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            List<Character> row = new ArrayList<>();
            List<Character> col = new ArrayList<>();

            for (int j = 0; j < board[0].length; j++) {
                String subgridKey = Math.floorDiv(i, 3) + "_" + Math.floorDiv(j, 3);
                char gridRowElement = board[i][j];
                char gridColElement = board[j][i];

                if (row.contains(gridRowElement)) {
                    return false;
                }

                if (col.contains(gridColElement)) {
                    return false;
                }

                if (gridColElement != '.') {
                    col.add(gridColElement);
                }

                if (gridRowElement != '.') {
                    row.add(gridRowElement);

                    List<Character> subgrid = subgrids.getOrDefault(subgridKey, new ArrayList<>());

                    if (subgrids.containsKey(subgridKey) && subgrid.contains(gridRowElement)) {
                        return false;
                    }

                    subgrid.add(gridRowElement);
                    subgrids.put(subgridKey, subgrid);
                }
            }
        }

        return true;
    }
}
