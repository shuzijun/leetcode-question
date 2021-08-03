package com.shuzijun.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>请你判断一个 <code>9x9</code> 的数独是否有效。只需要<strong> 根据以下规则</strong> ，验证已经填入的数字是否有效即可。</p>
 *
 * <ol>
 * <li>数字 <code>1-9</code> 在每一行只能出现一次。</li>
 * <li>数字 <code>1-9</code> 在每一列只能出现一次。</li>
 * <li>数字 <code>1-9</code> 在每一个以粗实线分隔的 <code>3x3</code> 宫内只能出现一次。（请参考示例图）</li>
 * </ol>
 *
 * <p>数独部分空格内已填入了数字，空白格用 <code>'.'</code> 表示。</p>
 *
 * <p><strong>注意：</strong></p>
 *
 * <ul>
 * <li>一个有效的数独（部分已被填充）不一定是可解的。</li>
 * <li>只需要根据以上规则，验证已经填入的数字是否有效即可。</li>
 * </ul>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 * <img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2021/04/12/250px-sudoku-by-l2g-20050714svg.png" style="height:250px; width:250px" />
 * <pre>
 * <strong>输入：</strong>board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * <strong>输出：</strong>true
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>board =
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * <strong>输出：</strong>false
 * <strong>解释：</strong>除了第一行的第一个数字从<strong> 5</strong> 改为 <strong>8 </strong>以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。</pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>board.length == 9</code></li>
 * <li><code>board[i].length == 9</code></li>
 * <li><code>board[i][j]</code> 是一位数字或者 <code>'.'</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>哈希表</li><li>矩阵</li></div></div><br><div><li>👍 562</li><li>👎 0</li></div>
 */

public class Q36ValidSudoku {
    public static void main(String[] args) {
        Solution solution = new Q36ValidSudoku().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            List<Integer>[] rows = new List[9];
            List<Integer>[] columns = new List[9];
            List<Integer>[] boxes = new List[9];
            for (int i = 0; i < 9; i++) {
                rows[i] = new ArrayList<Integer>();
                columns[i] = new ArrayList<Integer>();
                boxes[i] = new ArrayList<Integer>();
            }
            for (int i = 0; i < board.length; i++) {
                char[] row = board[i];
                for (int j = 0; j < row.length; j++) {
                    char num = board[i][j];
                    if (num == '.') {
                        continue;
                    }
                    Integer integer = Integer.valueOf(num);
                    if (rows[i].contains(integer)) {
                        return false;
                    }
                    rows[i].add(integer);
                    if (columns[j].contains(integer)) {
                        return false;
                    }
                    columns[j].add(integer);
                    int boxeInx = (i / 3) * 3 + j / 3;
                    if (boxes[boxeInx].contains(integer)) {
                        return false;
                    }
                    boxes[boxeInx].add(integer);
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}