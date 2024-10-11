import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionsSystem {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        Arrays.sort(products);
        Trie trie = new Trie();
        for (String product : products) {
            trie.insert(product);
        }
        for (int i = 0; i < searchWord.length(); i++) {
            res.add(trie.startsWith(searchWord.substring(0, i + 1)));
        }
        return res;
    }
    
    public static void main(String[] args) {
        SearchSuggestionsSystem search = new SearchSuggestionsSystem();
        List<List<String>> list = search.suggestedProducts(new String[]{"mobile","mouse","moneypot","monitor","mousepad"}, "mouse");
        System.out.println(list);
        List<List<String>> list1 = search.suggestedProducts(new String[]{"havana"}, "havana");
        System.out.println(list1);
        List<List<String>> list2 = search.suggestedProducts(new String[]{"havana"}, "tatiana");
        System.out.println(list2);
    }
}

class TrieNode {
    char value;
    TrieNode[] children;
    boolean isWordEnd;
    String endWord;

    public TrieNode(char value) {
        this.value = value;
        this.children = new TrieNode[26];
        this.isWordEnd = false;
        this.endWord = null;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode('\0');
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode(ch);
            }
            curr = curr.children[index];
        }
        curr.isWordEnd = true;
        curr.endWord = word;
    }

    public List<String> startsWith(String prefix) {
        TrieNode curr = root;
        List<String> list = new ArrayList<>();
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (curr.children[index] == null)
                return new ArrayList<>();
            curr = curr.children[index];
        }
        searchMore(curr, list);
        return list;
    }

    private void searchMore(TrieNode node, List<String> list) {
        if (list.size() == 3)
            return;
        if (node.endWord != null) {
            list.add(node.endWord);
        }
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                searchMore(node.children[i], list);
            }
        }
    }
}