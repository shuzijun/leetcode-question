<script type="text/javascript" src="https://assets.leetcode.com/static_assets/public/webpack_bundles/runtime.87724bff8.js" ></script>
<script type="text/javascript" src="https://assets.leetcode.com/static_assets/public/webpack_bundles/common/global.aea96cf9b.js" ></script>
<script type="text/javascript" src="https://assets.leetcode.com/static_assets/public/webpack_bundles/common/styles/index.98d412a4d.js" ></script>
<script type="text/javascript" src="https://assets.leetcode.com/static_assets/public/webpack_bundles/common/styles/new/index.09dc4f570.js" ></script>
<script type="text/javascript" src="https://assets.leetcode.com/static_assets/public/webpack_bundles/vendor-libs.74b989d8f.js" ></script>
<script type="text/javascript" src="https://assets.leetcode.com/static_assets/public/webpack_bundles/common-libs.92d89ad09.js" ></script>
<script type="text/javascript" src="https://assets.leetcode.com/static_assets/public/webpack_bundles/new-libs.72b4a7e88.js" ></script>
<script type="text/javascript" src="https://assets.leetcode.com/static_assets/public/webpack_bundles/new-apps/desktop.107bd7009.js" ></script>

## Video Solution

---

<div class='video-preview'></div>

<div>&nbsp;
</div>

## Solution Article

---

#### Approach 1: Brute Force

**Intuition**

Check all the substring one by one to see if it has no duplicate character.

**Algorithm**

Suppose we have a function `boolean allUnique(String substring)` which will return true if the characters in the substring are all unique, otherwise false. We can iterate through all the possible substrings of the given string `s` and call the function `allUnique`. If it turns out to be true, then we update our answer of the maximum length of substring without duplicate characters.

Now let's fill the missing parts:

1. To enumerate all substrings of a given string, we enumerate the start and end indices of them. Suppose the start and end indices are $$i$$ and $$j$$, respectively. Then we have $$0 \leq i \lt j \leq n$$ (here end index $$j$$ is exclusive by convention). Thus, using two nested loops with $$i$$ from 0 to $$n - 1$$ and $$j$$ from $$i+1$$ to $$n$$, we can enumerate all the substrings of `s`.

2. To check if one string has duplicate characters, we can use a set. We iterate through all the characters in the string and put them into the `set` one by one. Before putting one character, we check if the set already contains it. If so, we return `false`. After the loop, we return `true`.

<iframe src="https://leetcode.com/playground/cqFhjPgG/shared" frameBorder="0" width="100%" height="500" name="cqFhjPgG"></iframe>

**Complexity Analysis**

* Time complexity : $$O(n^3)$$.

  To verify if characters within index range $$[i, j)$$ are all unique, we need to scan all of them. Thus, it costs $$O(j - i)$$ time.

  For a given `i`, the sum of time costed by each $$j \in [i+1, n]$$ is

  $$
  \sum_{i+1}^{n}O(j - i)
  $$

  Thus, the sum of all the time consumption is:

  $$
  O\left(\sum_{i = 0}^{n - 1}\left(\sum_{j = i + 1}^{n}(j - i)\right)\right) =
  O\left(\sum_{i = 0}^{n - 1}\frac{(1 + n - i)(n - i)}{2}\right) =
  O(n^3)
  $$

* Space complexity : $$O(min(n, m))$$. We need $$O(k)$$ space for checking a substring has no duplicate characters, where $$k$$ is the size of the `Set`. The size of the Set is upper bounded by the size of the string $$n$$ and the size of the charset/alphabet $$m$$.
  <br />
  <br />
---
#### Approach 2: Sliding Window

**Algorithm**

The naive approach is very straightforward. But it is too slow. So how can we optimize it?

In the naive approaches, we repeatedly check a substring to see if it has duplicate character. But it is unnecessary. If a substring $$s_{ij}$$ from index $$i$$ to $$j - 1$$ is already checked to have no duplicate characters. We only need to check if $$s[j]$$ is already in the substring $$s_{ij}$$.

To check if a character is already in the substring, we can scan the substring, which leads to an $$O(n^2)$$ algorithm. But we can do better.

By using HashSet as a sliding window, checking if a character in the current can be done in $$O(1)$$.

A sliding window is an abstract concept commonly used in array/string problems. A window is a range of elements in the array/string which usually defined by the start and end indices, i.e. $$[i, j)$$ (left-closed, right-open). A sliding window is a window "slides" its two boundaries to the certain direction. For example, if we slide $$[i, j)$$ to the right by $$1$$ element, then it becomes $$[i+1, j+1)$$ (left-closed, right-open).

Back to our problem. We use HashSet to store the characters in current window $$[i, j)$$ ($$j = i$$ initially). Then we slide the index $$j$$ to the right. If it is not in the HashSet, we slide $$j$$ further. Doing so until s[j] is already in the HashSet. At this point, we found the maximum size of substrings without duplicate characters start with index $$i$$. If we do this for all $$i$$, we get our answer.

<iframe src="https://leetcode.com/playground/ivDRgKu6/shared" frameBorder="0" width="100%" height="500" name="ivDRgKu6"></iframe>

**Complexity Analysis**

* Time complexity : $$O(2n) = O(n)$$. In the worst case each character will be visited twice by $$i$$ and $$j$$.

* Space complexity : $$O(min(m, n))$$. Same as the previous approach. We need $$O(k)$$ space for the sliding window, where $$k$$ is the size of the `Set`. The size of the Set is upper bounded by the size of the string $$n$$ and the size of the charset/alphabet $$m$$.
  <br />
  <br />
---
#### Approach 3: Sliding Window Optimized

The above solution requires at most 2n steps. In fact, it could be optimized to require only n steps. Instead of using a set to tell if a character exists or not, we could define a mapping of the characters to its index. Then we can skip the characters immediately when we found a repeated character.

The reason is that if $$s[j]$$ have a duplicate in the range $$[i, j)$$ with index $$j'$$, we don't need to increase $$i$$ little by little. We can skip all the elements in the range $$[i, j']$$ and let $$i$$ to be $$j' + 1$$ directly.

**Java (Using HashMap)**

<iframe src="https://leetcode.com/playground/HRFnMpL9/shared" frameBorder="0" width="100%" height="344" name="HRFnMpL9"></iframe>

Here is a visualization of the above code.

<div class="video-container">
<iframe src="https://player.vimeo.com/video/484238122" width="640" height="360" frameborder="0" allow="autoplay; fullscreen" allowfullscreen></iframe>
</div>

**Java (Assuming ASCII 128)**

The previous implements all have no assumption on the charset of the string `s`.

If we know that the charset is rather small, we can replace the `Map` with an integer array as direct access table.

Commonly used tables are:

* `int[26]` for Letters 'a' - 'z' or 'A' - 'Z'
* `int[128]` for ASCII
* `int[256]` for Extended ASCII

<iframe src="https://leetcode.com/playground/LEu2h2DZ/shared" frameBorder="0" width="100%" height="480" name="LEu2h2DZ"></iframe>

**Complexity Analysis**

* Time complexity : $$O(n)$$. Index $$j$$ will iterate $$n$$ times.

* Space complexity (HashMap) : $$O(min(m, n))$$. Same as the previous approach.

* Space complexity (Table): $$O(m)$$. $$m$$ is the size of the charset.