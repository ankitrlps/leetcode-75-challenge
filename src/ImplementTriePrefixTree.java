public class ImplementTriePrefixTree {
    
    class TrieNode {
        TrieNode[] children;
        boolean isWordEnd;
    
        public TrieNode() {
            this.children = new TrieNode[26];
            this.isWordEnd = false;
        }
    }

    class Trie {

        TrieNode root;
    
        public Trie() {
            root = new TrieNode();
        }
        
        public void insert(String word) {
            TrieNode curr = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (curr.children[index] == null) {
                    curr.children[index] = new TrieNode();
                }
                curr = curr.children[index];
            }
            curr.isWordEnd = true;
        }
        
        public boolean search(String word) {
            TrieNode curr = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (curr.children[index] == null) return false;
                curr = curr.children[index];
            }
            return curr.isWordEnd;
        }
        
        public boolean startsWith(String prefix) {
            TrieNode curr = root;
            for (char ch : prefix.toCharArray()) {
                int index = ch - 'a';
                if (curr.children[index] == null) return false;
                curr = curr.children[index];
            }
            return true;
        }
    }

    public static void main(String[] args) {
        
    }
}
