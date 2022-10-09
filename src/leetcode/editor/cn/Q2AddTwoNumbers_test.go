package main

import "testing"

/**
<p>给你两个&nbsp;<strong>非空</strong> 的链表，表示两个非负的整数。它们每位数字都是按照&nbsp;<strong>逆序</strong>&nbsp;的方式存储的，并且每个节点只能存储&nbsp;<strong>一位</strong>&nbsp;数字。</p>

<p>请你将两个数相加，并以相同形式返回一个表示和的链表。</p>

<p>你可以假设除了数字 0 之外，这两个数都不会以 0&nbsp;开头。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2021/01/02/addtwonumber1.jpg" style="width: 483px; height: 342px;" />
<pre>
<strong>输入：</strong>l1 = [2,4,3], l2 = [5,6,4]
<strong>输出：</strong>[7,0,8]
<strong>解释：</strong>342 + 465 = 807.
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>l1 = [0], l2 = [0]
<strong>输出：</strong>[0]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
<strong>输出：</strong>[8,9,9,9,0,0,0,1]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
 <li>每个链表中的节点数在范围 <code>[1, 100]</code> 内</li>
 <li><code>0 &lt;= Node.val &lt;= 9</code></li>
 <li>题目数据保证列表表示的数字不含前导零</li>
</ul>

<div><details><summary>Related Topics</summary><div><li>递归</li><li>链表</li><li>数学</li></div></details></div>
<div><li>👍 8741</li><li>👎 0</li></div>
*/

func TestAddTwoNumbers(t *testing.T) {
	l1 := &ListNode{2, &ListNode{4, &ListNode{3, nil}}}
	l2 := &ListNode{5, &ListNode{6, &ListNode{4, nil}}}
	l3 := addTwoNumbers(l1, l2)
	t.Log(l3.String())
}

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func addTwoNumbers(l1 *ListNode, l2 *ListNode) (head *ListNode) {
	var tail *ListNode

	iter1, iter2, carry := l1, l2, 0 // 迭代器，避免对原链表修改

	for iter1 != nil || iter2 != nil {
		n1, n2 := 0, 0
		if iter1 != nil {
			n1 = iter1.Val
			iter1 = iter1.Next
		}
		if iter2 != nil {
			n2 = iter2.Val
			iter2 = iter2.Next
		}
		sum := n1 + n2 + carry
		sum, carry = sum%10, sum/10
		if head != nil {
			tail.Next = &ListNode{sum, nil}
			tail = tail.Next
		} else {
			head = &ListNode{sum, nil}
			tail = head
		}
	}
	if carry > 0 {
		tail.Next = &ListNode{carry, nil}
	}
	return
}

//leetcode submit region end(Prohibit modification and deletion)
