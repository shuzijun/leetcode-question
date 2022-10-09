package main

import "testing"

/**
<p>给定一个平衡括号字符串&nbsp;<code>S</code>，按下述规则计算该字符串的分数：</p>

<ul>
 <li><code>()</code> 得 1 分。</li>
 <li><code>AB</code> 得&nbsp;<code>A + B</code>&nbsp;分，其中 A 和 B 是平衡括号字符串。</li>
 <li><code>(A)</code> 得&nbsp;<code>2 * A</code>&nbsp;分，其中 A 是平衡括号字符串。</li>
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入： </strong>"()"
<strong>输出： </strong>1
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入： </strong>"(())"
<strong>输出： </strong>2
</pre>

<p><strong>示例&nbsp;3：</strong></p>

<pre><strong>输入： </strong>"()()"
<strong>输出： </strong>2
</pre>

<p><strong>示例&nbsp;4：</strong></p>

<pre><strong>输入： </strong>"(()(()))"
<strong>输出： </strong>6
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
 <li><code>S</code>&nbsp;是平衡括号字符串，且只含有&nbsp;<code>(</code>&nbsp;和&nbsp;<code>)</code>&nbsp;。</li>
 <li><code>2 &lt;= S.length &lt;= 50</code></li>
</ol>

<div><details><summary>Related Topics</summary><div><li>栈</li><li>字符串</li></div></details></div>
<div><li>👍 382</li><li>👎 0</li></div>
*/

func TestScoreOfParentheses(t *testing.T) {
	t.Log(scoreOfParentheses("()"))
	t.Log(scoreOfParentheses("(())"))
	t.Log(scoreOfParentheses("()()"))
	t.Log(scoreOfParentheses("(()(()))"))
}

//leetcode submit region begin(Prohibit modification and deletion)
func scoreOfParentheses(s string) int {
	st := []int{0}
	for _, c := range s {
		if c == '(' {
			st = append(st, 0)
		} else {
			v := st[len(st)-1]
			st = st[:len(st)-1]
			st[len(st)-1] += max(2*v, 1)
		}
	}
	return st[0]
}
func max(a, b int) int {
	if b > a {
		return b
	}
	return a
}

//leetcode submit region end(Prohibit modification and deletion)
