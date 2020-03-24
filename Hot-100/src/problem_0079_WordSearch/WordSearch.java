package problem_0079_WordSearch;

/*
 * 79. 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 示例:
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *
 * 提示：
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 */
public class WordSearch {
    /*
     * 方法：回溯
     */
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        int[][] direction = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        boolean[][] marked = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, i, j, word, 0, marked, direction)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j,
                        String word, int next,
                        boolean[][] marked, int[][] direction) {
        if (next == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length
                || marked[i][j] || board[i][j] != word.charAt(next)) {
            return false;
        }
        marked[i][j] = true;
        for (int[] direct : direction) {
            // 剪枝
            if (dfs(board, i + direct[0], j + direct[1], word, next + 1, marked, direction)) {
                return true;
            }
        }
        // 状态重置
        marked[i][j] = false;
        return false;
    }
}
