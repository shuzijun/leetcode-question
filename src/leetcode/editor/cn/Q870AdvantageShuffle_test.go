package main

import (
	"sort"
	"testing"
)

/**
<p>给定两个大小相等的数组&nbsp;<code>nums1</code>&nbsp;和&nbsp;<code>nums2</code>，<code>nums1</code>&nbsp;相对于 <code>nums2</code> 的<em>优势</em>可以用满足&nbsp;<code>nums1[i] &gt; nums2[i]</code>&nbsp;的索引 <code>i</code>&nbsp;的数目来描述。</p>

<p>返回 <font color="#c7254e" face="Menlo, Monaco, Consolas, Courier New, monospace" size="1"><span style="background-color: rgb(249, 242, 244);">nums1</span></font>&nbsp;的<strong>任意</strong>排列，使其相对于 <code>nums2</code>&nbsp;的优势最大化。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums1 = [2,7,11,15], nums2 = [1,10,4,11]
<strong>输出：</strong>[2,11,7,15]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums1 = [12,24,8,32], nums2 = [13,25,32,11]
<strong>输出：</strong>[24,32,8,12]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
 <li><code>1 &lt;= nums1.length &lt;= 10<sup>5</sup></code></li>
 <li><code>nums2.length == nums1.length</code></li>
 <li><code>0 &lt;= nums1[i], nums2[i] &lt;= 10<sup>9</sup></code></li>
</ul>

<div><details><summary>Related Topics</summary><div><li>贪心</li><li>数组</li><li>双指针</li><li>排序</li></div></details></div>
<div><li>👍 289</li><li>👎 0</li></div>
*/

func TestAdvantageCount(t *testing.T) {
	t.Log(advantageCount([]int{2, 7, 11, 15}, []int{1, 10, 4, 11}))
}

//leetcode submit region begin(Prohibit modification and deletion)
func advantageCount(nums1 []int, nums2 []int) []int {
	n := len(nums1)
	ans := make([]int, n)
	sort.Ints(nums1)
	ids := make([]int, n)
	for i := range ids {
		ids[i] = i
	}
	sort.Slice(ids, func(i, j int) bool {
		return nums2[ids[i]] < nums2[ids[j]]
	})

	left, right := 0, n-1
	for _, x := range nums1 {
		if x > nums2[ids[left]] {
			ans[ids[left]] = x
			left++
		} else {
			ans[ids[right]] = x
			right--
		}
	}
	return ans
}

//leetcode submit region end(Prohibit modification and deletion)
