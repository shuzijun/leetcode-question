package main

import "testing"

/**
<p>给你长度相等的两个字符串 <code>s1</code> 和 <code>s2</code> 。一次<strong> 字符串交换 </strong>操作的步骤如下：选出某个字符串中的两个下标（不必不同），并交换这两个下标所对应的字符。</p>

<p>如果对 <strong>其中一个字符串</strong> 执行 <strong>最多一次字符串交换</strong> 就可以使两个字符串相等，返回 <code>true</code> ；否则，返回 <code>false</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>s1 = "bank", s2 = "kanb"
<strong>输出：</strong>true
<strong>解释：</strong>例如，交换 s2 中的第一个和最后一个字符可以得到 "bank"
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>s1 = "attack", s2 = "defend"
<strong>输出：</strong>false
<strong>解释：</strong>一次字符串交换无法使两个字符串相等
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>s1 = "kelb", s2 = "kelb"
<strong>输出：</strong>true
<strong>解释：</strong>两个字符串已经相等，所以不需要进行字符串交换
</pre>

<p><strong>示例 4：</strong></p>

<pre><strong>输入：</strong>s1 = "abcd", s2 = "dcba"
<strong>输出：</strong>false
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
 <li><code>1 &lt;= s1.length, s2.length &lt;= 100</code></li>
 <li><code>s1.length == s2.length</code></li>
 <li><code>s1</code> 和 <code>s2</code> 仅由小写英文字母组成</li>
</ul>

<div><details><summary>Related Topics</summary><div><li>哈希表</li><li>字符串</li><li>计数</li></div></details></div>
<div><li>👍 78</li><li>👎 0</li></div>
*/

func TestAreAlmostEqual(t *testing.T) {
	t.Log(areAlmostEqual("bank", "kanb"))
}

//leetcode submit region begin(Prohibit modification and deletion)
func areAlmostEqual(s1 string, s2 string) bool {
	i, j := -1, -1
	for k := 0; k < len(s1); k++ {
		if s1[k] != s2[k] {
			if i == -1 {
				i = k
			} else if j == -1 {
				j = k
			} else {
				return false
			}
		}
	}

	return i == -1 || j != -1 && s1[i] == s2[j] && s1[j] == s2[i]
}

//leetcode submit region end(Prohibit modification and deletion)
