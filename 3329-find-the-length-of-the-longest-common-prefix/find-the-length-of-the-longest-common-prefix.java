class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie trie = new Trie();
        int max = 0;

        for (int elem : arr1) {
            trie.insert(elem);
        }

        for (int elem : arr2) {
            max = Math.max(max, trie.maxLen(elem));
        }

        return max;
    }
}

class Node {
    Map<Character, Node> children;

    public Node() {
        children = new HashMap<>();
    }
}

class Trie {

    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(int number) {
        String s = Integer.toString(number);

        Node curr = root;

        for (char ch : s.toCharArray()) {
            curr.children.putIfAbsent(ch, new Node());
            curr = curr.children.get(ch);
        }
    }

    public int maxLen(int number) {
        String s = Integer.toString(number);

        Node curr = root;
        int len = 0;

        for (char ch : s.toCharArray()) {
            if (!curr.children.containsKey(ch)) {
                break;
            }

            curr = curr.children.get(ch);
            len++;
        }

        return len;
    }
}