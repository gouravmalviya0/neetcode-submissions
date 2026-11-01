class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        return solveNQueens(board, 0);
    }

    public List<List<String>> solveNQueens(boolean[][] board, int row) {
        if (board.length == row) {
            List<List<String>> ans = new ArrayList<>();
            List<String> list = new ArrayList<>();
            for(int i=0;i<board.length;i++) {
                String s = "";
                for(int j=0;j<board.length;j++) {
                    if(board[i][j]) {
                        s+= 'Q';
                    } else {
                        s+= '.';
                    }
                }
                list.add(s);
            }
            ans.add(list);
            return ans;
        }

        List<List<String>> ans = new ArrayList<>();
        for(int col = 0;col< board.length;col++) {
            if(isSafe(board, row, col)) {
                board[row][col] = true;
                ans.addAll(solveNQueens(board, row+1));
                board[row][col] = false;
            }        
        }

        return ans;
    }

    private boolean isSafe(boolean[][] board, int row, int col) {

        for (int i=0;i<row;i++) {
            if(board[i][col]) {
                return false;
            }
        }

        int min = Math.min(row, col);
        for(int i=1;i<=min;i++) {
            if(board[row-i][col-i]) {
                return false;
            }
        }

        // int minRight = Math.min(row, board.length - col -1);
        // for(int i=1;i<=minRight;i++) {
        //     if(board[row-i][col+i]) {
        //         return false;
        //     }
        // }

        int lRow = row-1;
        int lCol = col+1;

        while(lRow >= 0 && lCol < board.length) {            
            if(board[lRow][lCol]) {
                return false;
            }
            lRow = lRow-1;
            lCol = lCol+1;
        }

        return true;
    }
}
