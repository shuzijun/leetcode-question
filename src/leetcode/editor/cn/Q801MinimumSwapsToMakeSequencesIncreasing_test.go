package main

import "testing"

/**
<p>我们有两个长度相等且不为空的整型数组&nbsp;<code>nums1</code>&nbsp;和&nbsp;<code>nums2</code>&nbsp;。在一次操作中，我们可以交换&nbsp;<code>nums1[i]</code>&nbsp;和&nbsp;<code>nums2[i]</code>的元素。</p>

<ul>
 <li>例如，如果 <code>nums1 = [1,2,3,<u>8</u>]</code> ， <code>nums2 =[5,6,7,<u>4</u>]</code> ，你可以交换 <code>i = 3</code> 处的元素，得到 <code>nums1 =[1,2,3,4]</code> 和 <code>nums2 =[5,6,7,8]</code> 。</li>
</ul>

<p>返回 <em>使 <code>nums1</code> 和 <code>nums2</code> <strong>严格递增&nbsp;</strong>所需操作的最小次数</em> 。</p>

<p>数组&nbsp;<code>arr</code>&nbsp;<strong>严格递增</strong> 且&nbsp;&nbsp;<code>arr[0] &lt; arr[1] &lt; arr[2] &lt; ... &lt; arr[arr.length - 1]</code>&nbsp;。</p>

<p><b>注意：</b></p>

<ul>
 <li>用例保证可以实现操作。</li>
</ul>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> nums1 = [1,3,5,4], nums2 = [1,2,3,7]
<strong>输出:</strong> 1
<strong>解释: </strong>
交换 A[3] 和 B[3] 后，两个数组如下:
A = [1, 3, 5, 7] ， B = [1, 2, 3, 4]
两个数组均为严格递增的。</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> nums1 = [0,3,5,8,9], nums2 = [2,1,4,6,9]
<strong>输出:</strong> 1
</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul>
 <li><code>2 &lt;= nums1.length &lt;= 10<sup>5</sup></code></li>
 <li><code>nums2.length == nums1.length</code></li>
 <li><code>0 &lt;= nums1[i], nums2[i] &lt;= 2 * 10<sup>5</sup></code></li>
</ul>

<div><details><summary>Related Topics</summary><div><li>数组</li><li>动态规划</li></div></details></div>
<div><li>👍 371</li><li>👎 0</li></div>
*/

func TestMinSwap(t *testing.T) {
	t.Log(minSwap([]int{1, 3, 5, 4}, []int{1, 2, 3, 7}))
	t.Log(minSwap([]int{0, 3, 5, 8, 9}, []int{2, 1, 4, 6, 9}))
}

//leetcode submit region begin(Prohibit modification and deletion)
func minSwap(nums1 []int, nums2 []int) int {
	dp := make([][2]int, len(nums1))
	dp[0][0] = 0
	dp[0][1] = 1
	for i := 1; i < len(nums1); i++ {
		a1 := nums1[i-1]
		a2 := nums1[i]
		b1 := nums2[i-1]
		b2 := nums2[i]

		if (a1 < a2 && b1 < b2) && (a1 < b2 && b1 < a2) {
			dp[i][0] = min(dp[i-1][0], dp[i-1][1])
			dp[i][1] = min(dp[i-1][0], dp[i-1][1]) + 1
		} else if a1 < a2 && b1 < b2 {
			dp[i][0] = dp[i-1][0]
			dp[i][1] = dp[i-1][1] + 1
		} else {
			dp[i][0] = dp[i-1][1]
			dp[i][1] = dp[i-1][0] + 1
		}
	}
	return min(dp[len(nums1)-1][0], dp[len(nums1)-1][1])
}
func min(a, b int) int {
	if a > b {
		return b
	}
	return a
}

//leetcode submit region end(Prohibit modification and deletion)
