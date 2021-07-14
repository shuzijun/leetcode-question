package com.shuzijun.leetcode;

/**
 * @author : CAOMU
 * @version : 1.0
 * @since : 2021/02/16, Tue, 12:36
 */
public class Trie {
    Trie[] children;
    boolean isWord;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        this.children = new Trie[26];
        this.isWord = false;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        this.insert(word.toCharArray());
    }

    public void insert(char[] chars) {
        Trie curr = this;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new Trie();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie leaf = this.findLeafTrie(word);
        return leaf != null && leaf.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return this.findLeafTrie(prefix) != null;
    }

    private Trie findLeafTrie(String word) {
        Trie curr = this;
        for (int i = 0; i < word.length(); i++) {
            curr = curr.children[word.charAt(i) - 'a'];
            if (curr == null) {
                return null;
            }
        }
        return curr;
    }
}