package medium._回溯;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *  
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *  
 *
 * 提示：
 *
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _79_单词搜索 {
    /**
     * 本题采用回溯算法进行解决，首先了解一下什么是回溯算法：
     *      回溯算法实际上一个类似枚举的搜索尝试过程，主要是在搜索尝试过程中寻找问题的解，
     *      当发现已不满足求解条件时，就“回溯”返回，尝试别的路径。
     *      回溯法是一种选优搜索法，按选优条件向前搜索，以达到目标。
     *      但当探索到某一步时，发现原先选择并不优或达不到目标，就退回一步重新选择，
     *      这种走不通就退回再走的技术为回溯法，而满足回溯条件的某个状态的点称为“回溯点”。
     *      许多复杂的，规模较大的问题都可以使用回溯法，有“通用解题方法”的美称。
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        if(word.length() == 0){
            return false;
        }
        char start = word.charAt(0);
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(start != board[i][j]){
                    continue;
                }else{
                    if(find(board, word, 0, i, j, 's')){
                        return true;
                    }else{
                        continue;
                    }
                }
            }
        }
        return false;
    }


    /**
     *
     * @param board
     * @param word
     * @param index   word下标
     * @param x       当前的 board[x][y]
     * @param y       当前的 board[x][y]
     * @param pre      规定了s为开头  u为向上 d为向下 l为向左 r为向右
     *                 把已经经过的路径中的字母换成0，避免重复，这一趟走完再复原，以免影响其他方向的进行。
     * @return
     */
    private boolean find(char[][] board, String word, int index, int x, int y, char pre){
        //System.out.println("index:" + index + ", " + "x:" + x + ",y:" + y);
        if(index == word.length() - 1 && word.charAt(index) == board[x][y]){
            return true;
        }
        if(index >= word.length() || word.charAt(index) != board[x][y]){
            return false;
        }
        boolean found = false;
        //向上寻找
        if(!found && pre != 'd' && x > 0){
            char tmp = board[x][y];
            board[x][y] = '0';
            found = find(board, word, index + 1, x - 1, y, 'u');
            board[x][y] = tmp;
        }
        //向下寻找
        if(!found && pre != 'u' && x < board.length - 1){
            char tmp = board[x][y];
            board[x][y] = '0';
            found = find(board, word, index + 1, x + 1, y, 'd');
            board[x][y] = tmp;
        }
        //向左寻找
        if(!found && pre != 'r' && y > 0){
            char tmp = board[x][y];
            board[x][y] = '0';
            found = find(board, word, index + 1, x, y - 1, 'l');
            board[x][y] = tmp;
        }
        //向右寻找
        if(!found && pre != 'l' && y < board[0].length - 1){
            char tmp = board[x][y];
            board[x][y] = '0';
            found = find(board, word, index + 1, x, y + 1, 'r');
            board[x][y] = tmp;
        }
        return found;
    }
}
