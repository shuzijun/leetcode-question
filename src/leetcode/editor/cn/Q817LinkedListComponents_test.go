package main

import "testing"

/**
<p>给定链表头结点&nbsp;<code>head</code>，该链表上的每个结点都有一个 <strong>唯一的整型值</strong> 。同时给定列表&nbsp;<code>nums</code>，该列表是上述链表中整型值的一个子集。</p>

<p>返回列表&nbsp;<code>nums</code>&nbsp;中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表&nbsp;<code>nums</code>&nbsp;中）构成的集合。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1：</strong></p>

<p><img src="https://assets.leetcode.com/uploads/2021/07/22/lc-linkedlistcom1.jpg" /></p>

<pre>
<strong>输入:</strong> head = [0,1,2,3], nums = [0,1,3]
<strong>输出:</strong> 2
<strong>解释:</strong> 链表中,0 和 1 是相连接的，且 nums 中不包含 2，所以 [0, 1] 是 nums 的一个组件，同理 [3] 也是一个组件，故返回 2。</pre>

<p><strong>示例 2：</strong></p>

<p><strong>&nbsp;</strong><img src="https://assets.leetcode.com/uploads/2021/07/22/lc-linkedlistcom2.jpg" /></p>

<pre>
<strong>输入:</strong> head = [0,1,2,3,4], nums = [0,3,1,4]
<strong>输出:</strong> 2
<strong>解释:</strong> 链表中，0 和 1 是相连接的，3 和 4 是相连接的，所以 [0, 1] 和 [3, 4] 是两个组件，故返回 2。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
 <li>链表中节点数为<code>n</code></li>
 <li><code>1 &lt;= n &lt;= 10<sup>4</sup></code></li>
 <li><code>0 &lt;= Node.val &lt; n</code></li>
 <li><code>Node.val</code>&nbsp;中所有值 <strong>不同</strong></li>
 <li><code>1 &lt;= nums.length &lt;= n</code></li>
 <li><code>0 &lt;= nums[i] &lt; n</code></li>
 <li><code>nums</code> 中所有值 <strong>不同</strong></li>
</ul>

<div><details><summary>Related Topics</summary><div><li>数组</li><li>哈希表</li><li>链表</li></div></details></div>
<div><li>👍 167</li><li>👎 0</li></div>
*/

func TestNumComponents(t *testing.T) {
	t.Log(numComponents(&ListNode{Val: 0, Next: &ListNode{Val: 1, Next: &ListNode{Val: 2, Next: &ListNode{Val: 3}}}}, []int{0, 1, 3}))
}

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func numComponents(head *ListNode, nums []int) int {
	ans := 0
	set := make(map[int]bool)
	for _, num := range nums {
		set[num] = true
	}
	for isSet := false; head != nil; head = head.Next {
		if _, ok := set[head.Val]; !ok {
			isSet = false
		} else if !isSet {
			isSet = true
			ans++
		}

	}
	return ans
}

//leetcode submit region end(Prohibit modification and deletion)
