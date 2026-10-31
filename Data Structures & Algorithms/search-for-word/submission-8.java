class Solution {
    public boolean exist(char[][] board, String word) {
        boolean doesExist = false;
        for(int row = 0;row<board.length;row++) {
            for(int col = 0;col < board[0].length;col++) {
                if (board[row][col] == word.charAt(0)) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    visited[row][col] = true;
                    boolean found = findWord(board, row, col, 1, word, visited);
                    if (found) {
                        doesExist = true;
                        break;
                    }
                }
            }
            if (doesExist) {
                break;
            }
        }

        return doesExist;
    }

    boolean findWord(char[][] board, int row, int col, int n, String word, boolean[][] visited) {
        if (n == word.length()) {
            return true;
        }

        boolean result1 = false;
        boolean result2 = false;
        boolean result3 = false;
        boolean result4 = false;
        
        if (board[0].length > col+1 && !visited[row][col+1] && board[row][col+1] == word.charAt(n)) {
            visited[row][col+1] = true;
            result1 = findWord(board, row, col+1, n+1, word, visited);
            visited[row][col+1] = false;
        }

        if (board.length > row+1 &&  !visited[row+1][col] && board[row+1][col] == word.charAt(n)) {
            visited[row+1][col] = true;
            result2 =  findWord(board, row+1, col, n+1, word, visited);
            visited[row+1][col] = false;
        }

        if (col > 0 && !visited[row][col-1] && board[row][col-1] == word.charAt(n)) {
            visited[row][col-1] = true;
            result3 =   findWord(board, row, col-1, n+1, word, visited);
            visited[row][col-1] = false;
        }

        if (row > 0 && !visited[row-1][col] && board[row-1][col] == word.charAt(n)) {
            visited[row-1][col] = true;
            result4 =    findWord(board, row-1, col, n+1, word, visited);
            visited[row-1][col] = false;
        }

        return result1 || result2|| result3 ||result4;
    }
}
