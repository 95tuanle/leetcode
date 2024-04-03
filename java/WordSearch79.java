public class WordSearch79 {
    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(exist(board, word));

        word = "SEE";
        System.out.println(exist(board, word));

        word = "ABCB";
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        int rows = board.length, columns = board[0].length;
        boolean[][] visited = new boolean[rows][columns];
        char first = word.charAt(0);
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                if (first == board[i][j] && depthFirstSearch(board, word, visited, rows, columns, i, j, 0)) return true;
        return false;
    }

    private static boolean depthFirstSearch(char[][] board, String word, boolean[][] visited, int rows, int columns, int i, int j, int index) {
        if (index == word.length()) return true;
        if (i < 0 || i >= rows || j < 0 || j >= columns || word.charAt(index) != board[i][j] || visited[i][j])
            return false;
        visited[i][j] = true;
        index++;
        if (depthFirstSearch(board, word, visited, rows, columns, i + 1, j, index) || depthFirstSearch(board, word, visited, rows, columns, i - 1, j, index) || depthFirstSearch(board, word, visited, rows, columns, i, j + 1, index) || depthFirstSearch(board, word, visited, rows, columns, i, j - 1, index))
            return true;
        visited[i][j] = false;
        return false;
    }
}
