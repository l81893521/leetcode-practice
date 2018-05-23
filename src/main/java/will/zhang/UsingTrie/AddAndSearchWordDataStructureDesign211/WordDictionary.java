package will.zhang.UsingTrie.AddAndSearchWordDataStructureDesign211;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * LeetCode 211. 添加与搜索单词 - 数据结构设计
 * 设计一个支持以下两种操作的数据结构：
 * void addWord(word)
 * bool search(word)
 * search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
 * 示例:
 *
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * 说明:
 *
 * 你可以假设所有单词都是由小写字母 a-z 组成的。
 */
public class WordDictionary {

    //根节点
    private Node root;

    private class Node {
        //访问到当前Node的时候是否已经找到了一个单词
        public boolean isWord;
        //每一个节点的next都是TreeMap
        private HashMap<Character, Node> next;

        public Node(boolean isWord){
            this.isWord = isWord;
            next = new HashMap<>();
        }

        public Node(){
            this(false);
        }
    }

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            if(cur.next.get(c) == null)
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }
        if(!cur.isWord)
            cur.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(root, word, 0);
    }

    /**
     * 递归查找当前node是否包含单词word的索引index的字符
     * @param node
     * @param word
     * @param index
     * @return
     */
    private boolean match(Node node, String word, int index){
        //递归到底的情况
        if(index == word.length())
            return node.isWord;

        char c = word.charAt(index);
        //当前字符不是点
        if(c != '.'){
            if(node.next.get(c) == null){
                return false;
            }
            return match(node.next.get(c), word, index + 1);
        }else{ //当前字符是点
            //for循环所有字符
            for (char cc : node.next.keySet()) {
                if(match(node.next.get(cc), word, index + 1))
                    return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("map");
        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));

    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
