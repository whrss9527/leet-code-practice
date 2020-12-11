package medium;

/**
 * 根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 *
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 *
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 *
 *  
 *
 * 示例：
 *
 * 输入：
 * [
 *   [0,1,0],
 *   [0,0,1],
 *   [1,1,1],
 *   [0,0,0]
 * ]
 * 输出：
 * [
 *   [0,0,0],
 *   [1,0,1],
 *   [0,1,1],
 *   [0,1,0]
 * ]
 *  
 *
 * 进阶：
 *
 * 你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。
 * 本题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/game-of-life
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class _289_生命游戏 {
    /**
     * 解题思路：
     *        我们需要做的有两步
     *        1、将数组中元素的周围<=8个位置的元素拿出来统计有几个1（其实就是求和）
     *        2、比较1周围的1是否小于2大于3，否则继续生存；比较0附近的1是否等于3，否则继续死亡
     *        然后我们处理数组即可。
     *
     *        第一步怎么做呢？
     *        我们需要拿到数组元素周围的元素，我们不妨设想它为一个坐标（0，0）的点，我们将它周围的点取出来，进行相加
     *
     *        第二步？
     *        我们可以采用向右移位的思想，这样我们只需要处理接下来还生存的元素，而不再生存的元素右移一位之后都为0
     *
     *        请认真的看下面的代码，我为每一处都做了重点注释
     *
     * @param board
     */
    public static void gameOfLife(int[][] board) {

        int width = board[0].length;
        int height = board.length;

        for (int i=0;i<height;i++){
            for(int j = 0;j<width;j++){
                int num = count(board,i,j);

                if(board[i][j]==1){
                    //如果原先是存活的，我们只需要考虑接下来还存活的情况
                    //将它的值设为3 即二进制的 11
                    if(num>=2&&num<=3){
                        board[i][j]=3;
                    }
                }else{
                    //如果原先是死亡的，我们也只需要考虑它存活的情况
                    //将它的值设为2 即二进制的 10
                    if(num==3){
                        board[i][j]=2;
                    }
                }
            }
        }
        //对整个数组进行遍历，向右移一位
        //11>1  10>1  其他全部为0
        for (int i=0;i<height;i++){
            for(int j = 0;j<width;j++){
                board[i][j]=board[i][j]>>1;
            }
        }
    }
    private static int count(int [][]arr,int i,int j){
        //我们使用两个数组来模拟坐标轴的8个点，与i j相加则可拿到数组相应的八个点
        int [] aX={1,1,1,-1,-1,-1,0,0};
        int [] aY={0,1,-1,0,1,-1,1,-1};
        int count =0;
        for(int m = 0;m<8;m++){
            int x = aX[m]+i;
            int y = aY[m]+j;
            //如果越界，那么这个点是在数组靠边界的位置，跳过即可
            if(x<0||x>arr.length-1||y<0||y>arr[0].length-1) continue;
            //这里使用与运算 即 0 1 得 0  、 1 1 得 1
            count+=(arr[x][y] & 1);
        }

        return count;

    }
    //你可以更改返回值以后在这里进行测试
    public static void main(String[] args) {
        System.err.println("kk");
    }
}
