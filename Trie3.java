class Node {

    Node[] links = new Node[26];
    boolean flag = false;

    Node() { }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public Node get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    public void setEnd() {
        flag = true;
    }

    public boolean isEnd() {
        return flag;
    }
}

class Trie {

    private static Node root;

    Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++ ) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.put(ch, new Node());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    public boolean checkIfPrefixExists(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.containsKey(ch)) {
                node = node.get(ch);
                if (node.isEnd() == false) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

}

public class Trie3 {

    public String completeString(int n, String[] a) {
        Trie trie = new Trie();
        for (String word: a) {
            trie.insert(word);
        }
        String longest = "";
        for (String word: a) {
            if (trie.checkIfPrefixExists(word)) {
                if (word.length() > longest.length()) {
                    longest = word;
                } else if (word.length() == longest.length() && word.compareTo(longest) < 0) {
                    longest = word;
                }
            }
        }
        if (longest == "") {
            return "None";
        }
        return longest;
    }

}
