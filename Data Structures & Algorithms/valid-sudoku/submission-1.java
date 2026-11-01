class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean rowColumn = checkRowAndColumn(board);
        if (rowColumn) {
            return checkIndividualBoard(board);
        }
        return false;
    }

    private boolean checkRowAndColumn(char[][] board) {
        boolean finalResult = true;
        for(int row=0;row<board.length;row++) {
            for (int col = 0;col<board.length;col++) {
                if(board[row][col] != '.') {
                   // System.out.println(row + " " + col + " " + board[row][col]);
                    boolean result = checkIfValid(board, row, col);
                    if (!result) {
                        finalResult = false;
                        break;
                    }
                }
            }
            if (!finalResult) {
                break;
            }
        }

        return finalResult;
    }

    private boolean checkIfValid(char[][] board, int row, int col) {
        char ch = board[row][col];
        for(int i=row+1;i<board.length;i++) {
            if(ch == board[i][col]) {
                return false;
            }
        }

        for(int i=col+1;i<board.length;i++) {
            if(ch == board[row][i]) {
                return false;
            }
        }

        return true;
    }

    private boolean checkIndividualBoard(char[][] board) {
        boolean finalResult = true;
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                boolean[] arr = new boolean[10];
                for(int row=i*3;row<((i+1)*3);row++) {
                    for(int col=j*3;col<((j+1)*3);col++) {
                        if(board[row][col] == '.')
                            continue;
                        if(arr[board[row][col] - '0']) {
                            finalResult = false;
                            break;
                        } else {
                            arr[board[row][col] - '0'] = true;
                        }
                    }

                    if (!finalResult) {
                        break;
                    }
                }
                    if (!finalResult) {
                        break;
                    }                
            }
                                if (!finalResult) {
                        break;
                    }
        }
        return finalResult;
    }
}
