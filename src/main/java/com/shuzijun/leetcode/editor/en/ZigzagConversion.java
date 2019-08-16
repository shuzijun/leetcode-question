//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility) 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R
// 
//
// And then read line by line: "PAHNAPLSIIGYIR" 
//
// Write the code that will take a string and make this conversion given a number of rows: 
//
// 
//string convert(string s, int numRows); 
//
// Example 1: 
//
// 
//Input: s = "PAYPALISHIRING", numRows = 3
//Output: "PAHNAPLSIIGYIR"
// 
//
// Example 2: 
//
// 
//Input: s = "PAYPALISHIRING", numRows = 4
//Output: "PINALSIGYAHRPI"
//Explanation:
//
//P     I    N
//A   L S  I G
//Y A   H R
//P     I 
//

package com.shuzijun.leetcode.editor.en;
public class ZigzagConversion{
    public static void main(String[] args) {
         Solution solution = new ZigzagConversion().new Solution();
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int rowSize = (numRows - 1) * 2;
        char[] ss = s.toCharArray();
        int len = ss.length;
        int countRow = len / rowSize + 1;
        char[] newss = new char[countRow * rowSize];

        for (int i = 0; i < len; i++) {
            int thisRow = i / rowSize;
            int rowSerial = i % rowSize;

            if (rowSerial == 0) {
                newss[thisRow] = ss[i];
            } else if (rowSerial < numRows - 1) {
                newss[thisRow * 2 + countRow + (rowSerial - 1) * countRow * 2] = ss[i];
            } else if (rowSerial == numRows - 1) {
                newss[thisRow + countRow + (rowSerial - 1) * countRow * 2] = ss[i];
            } else {
                newss[(thisRow + 1) * 2 - 1 + countRow + ((numRows - rowSerial % numRows - 2) - 1) * countRow * 2] = ss[i];

            }
        }
        return String.valueOf(newss).replace("\u0000", "");

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
