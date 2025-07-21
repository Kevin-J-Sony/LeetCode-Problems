import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class prob37 {
    public static void main(String[] args) {
        /*
        String[] input = {"53..7....",
                          "6..195...",
                          ".98....6.",
                          "8...6...3",
                          "4..8.3..1",
                          "7...2...6",
                          ".6....28.",
                          "...419..5",
                          "....8..79"};
        */
        String[] input = {"......28.",
                          "....42...",
                          "..2..5..6",
                          "7..21.6..",
                          "..4.6.5..",
                          "..8.39..2",
                          "3..6..7..",
                          "...42....",
                          ".51......"};
        char[][] sudoku = new char[9][];
        for (int i = 0; i < 9; i++) {
            sudoku[i] = input[i].toCharArray();
        }
        for (int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(sudoku[i]));
        }
        System.out.println("\n\n------------------\n\n");
        /*
        char[][] sudoku = {{'5','3','.','.','7','.','.','.','.'},
                            {'6','.','.','1','9','5','.','.','.'},
                            {'.','9','8','.','.','.','.','6','.'},
                            {'8','.','.','.','6','.','.','.','3'},
                            {'4','.','.','8','.','3','.','.','1'},
                            {'7','.','.','.','2','.','.','.','6'},
                            {'.','6','.','.','.','.','2','8','.'},
                            {'.','.','.','4','1','9','.','.','5'},
                            {'.','.','.','.','8','.','.','7','9'}};
        */
        for (int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(sudoku[i]));
        }

        Solution37 sol = new Solution37();
        sol.solveSudoku(sudoku);

        System.out.println("\n\n");
        for (int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(sudoku[i]));
        }
    }
}

class Solution37 {

    class cell {
        int value;
        int numPossibilities;
        boolean[] potential_values;

        public cell() {
            this.value = -1;
            this.numPossibilities = 9;
            this.potential_values = new boolean[9];
            for (int i = 0; i < 9; i++) {
                this.potential_values[i] = true;
            }
        }
    }

    class pair {
        int r;
        int c;
        public pair(int x, int y) {
            this.r = x;
            this.c = y;
        }
    }

    public void updateConstraints(cell[][] cells, int r, int c, int v) {
        Queue<pair> q = new LinkedList<>();
        v -= 1;
        // update along row
        for (int col = 0; col < 9; col++) {
            if (cells[r][col].value == -1) { 
                if (cells[r][col].potential_values[v]) {
                    cells[r][col].potential_values[v] = false;
                    cells[r][col].numPossibilities -= 1;
                }
                if (cells[r][col].numPossibilities == 1) {
                    pair p = new pair(r, col);
                    q.add(p);
                }
            }
        }

        // update along column
        for (int row = 0; row < 9; row++) {
            if (cells[row][c].value == -1) {
                if (cells[row][c].potential_values[v]) {
                    cells[row][c].potential_values[v] = false;
                    cells[row][c].numPossibilities -= 1;
                }
                if (cells[row][c].numPossibilities == 1) {
                    pair p = new pair(row, c);
                    q.add(p);
                }
            }
        }

        // update along same block
        int block_row_idx = r / 3;
        int block_col_idx = c / 3;

        block_row_idx *= 3;
        block_col_idx *= 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int block_r = i + block_row_idx;
                int block_c = j + block_col_idx;
                if ((block_r != r || block_c != c) && (cells[block_r][block_c].value == -1)) {
                    if (cells[block_r][block_c].potential_values[v]) {
                        cells[block_r][block_c].potential_values[v] = false;
                        cells[block_r][block_c].numPossibilities -= 1;
                    }
                    if (cells[block_r][block_c].numPossibilities == 1) {
                        pair p = new pair(block_r, block_c);
                        q.add(p);
                    }
                }
            }
        }

        // check to see if there is any rows, columns, or three by threes which contain
        // a potential solution
        checkRows(cells, v + 1);
        checkColumns(cells, v + 1);
        checkThreeByThrees(cells, v + 1);

        // if there are any new cells that have reached the number of possible
        // values it could possibly be at zero, then also update
        while (!q.isEmpty()) {
            pair p = q.remove();
            
            for (int i = 0; i < 9; i++) {
                if (cells[p.r][p.c].potential_values[i]) {
                    cells[p.r][p.c].value = i + 1;
                    updateConstraints(cells, p.r, p.c, i + 1);
                }
            }
        }

    }

    public void checkThreeByThrees(cell[][] cells, int v) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int block_row_idx = i * 3;
                int block_col_idx = j * 3;

                boolean flag = false;
                int col_idx = -1;
                int row_idx = -1;
                for (int y = 0; y < 3; y++) {
                    for (int x = 0; x < 3; x++) {
                        if (cells[block_row_idx + y][block_col_idx + x].value == -1) {
                            if (cells[block_row_idx + y][block_col_idx + x].potential_values[v - 1]) {
                                if (col_idx == -1) {
                                    row_idx = block_row_idx + y;
                                    col_idx = block_col_idx + x;
                                } else {
                                    flag = true;
                                }
                            }
                        } else if (cells[block_row_idx + y][block_col_idx + x].value == v) {
                            flag = true;
                        }
                    }
                }

                if (!flag) {
                    cells[row_idx][col_idx].value = v;
                    cells[row_idx][col_idx].numPossibilities = 1;
                    for (int k = 0; k < 9; k++) {
                        cells[row_idx][col_idx].potential_values[k] = (cells[row_idx][col_idx].value == k + 1);
                    }

                    updateConstraints(cells, row_idx, col_idx, v);
                }
            }
        }
    }

    public void checkRows(cell[][] cells, int v) {
        // check every row to see if there is only one cell per row which has a possible value of v
        for (int row = 0; row < 9; row++) {
            boolean flag = false;
            int col_idx = -1;
            for (int col = 0; col < 9 && !flag; col++) {
                if (cells[row][col].value == -1) {
                    if (cells[row][col].potential_values[v - 1]) {
                        if (col_idx == -1) {
                            col_idx = col;
                        } else {
                            flag = true;
                        }
                    }
                } else if (cells[row][col].value == v) {
                    flag = true;
                }
            }

            if (!flag) {
                cells[row][col_idx].value = v;
                cells[row][col_idx].numPossibilities = 1;
                for (int i = 0; i < 9; i++) {
                    cells[row][col_idx].potential_values[i] = (cells[row][col_idx].value == i + 1);
                }

                updateConstraints(cells, row, col_idx, v);
            }
        }
    }

    public void checkColumns(cell[][] cells, int v) {
        // check every column to see if there is only one cell per column which has a possible value of v
        for (int col = 0; col < 9; col++) {
            boolean flag = false;
            int row_idx = -1;
            for (int row = 0; row < 9; row++) {
                if (cells[row][col].value == -1) {
                    if (cells[row][col].potential_values[v - 1]) {
                        if (row_idx == -1) {
                            row_idx = row;
                        } else {
                            flag = true;
                        }
                    }
                } else if (cells[row][col].value == v) {
                    flag = true;
                }
            }

            if (!flag) {
                cells[row_idx][col].value = v;
                cells[row_idx][col].numPossibilities = 1;
                for (int i = 0; i < 9; i++) {
                    cells[row_idx][col].potential_values[i] = (cells[row_idx][col].value == i + 1);
                }

                updateConstraints(cells, row_idx, col, v);
            }
        }
    }

    public boolean isValid(cell[][] cells, int r, int c, int num) {
        // if the number appears in the row or column, 
        for (int row = 0; row < 9; row++) {
            if (cells[row][c].value == num && row != r) {
                return false;
            }
        }

        for (int col = 0; col < 9; col++) {
            if (cells[r][col].value == num && col != c) {
                return false;
            }
        }

        // update along same block
        int block_row_idx = r / 3;
        int block_col_idx = c / 3;

        block_row_idx *= 3;
        block_col_idx *= 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int block_r = i + block_row_idx;
                int block_c = j + block_col_idx;
                if (cells[block_r][block_c].value == num && !(block_r == r && block_c == c)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean solve(cell[][] cells) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                // fill in empty cells
                if (cells[row][col].value == -1) {
                    for (int i = 0; i < 9; i++) {
                        // to cut on computation, only put in values which are valid
                        if (cells[row][col].potential_values[i]) {
                            if (isValid(cells, row, col, i + 1)) {
                                cells[row][col].value = i + 1;
                                if (solve(cells)) {
                                    return true;
                                } else {
                                    cells[row][col].value = -1;
                                }
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        // since we KNOW that there is only ONE solution for this board
        // we can be comfortable in using constraints to narrow down the solutions
        // at the end
        cell[][] cells = new cell[9][9];

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                cells[row][col] = new cell();
            }
        }
        
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] != '.') {
                    // set the value of this cell
                    cells[row][col].value = board[row][col] - '0';
                    cells[row][col].numPossibilities = 1;
                    for (int i = 0; i < 9; i++) {
                        cells[row][col].potential_values[i] = (cells[row][col].value == i + 1);
                    }

                    // update all the constrains for different
                    updateConstraints(cells, row, col, cells[row][col].value);
                }
            }
        }

        // all the easy solutions have been found now
        // so solve using recursion 
        solve(cells);

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    if (cells[row][col].value != -1) {
                        boolean flag = false;
                        for (int i = 0; i < 9 && !flag; i++) {
                            if (cells[row][col].potential_values[i]) {
                                board[row][col] = (char) ('0' + cells[row][col].value);
                                flag = true;
                            }
                        }
                    }
                }
            }
        }

    }
}