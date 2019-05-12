package leetcodeOJ;

public class __720LongestWordInDictionary {
    /*public String longestWord(String[] words) {
        if(null==words||words.length<2) return "";
        Set<String> set = new HashSet<>(Arrays.asList(words));
        String longestWord = "";
        for (String word:words) {
            if(set.contains(word.substring(0, word.length()-1))){
                if(word.length()<longestWord.length()) continue;
                else if(word.length()==longestWord.length() && !compareDicOrder(word, longestWord)) longestWord=word;
                else if(word.length()>longestWord.length()) longestWord = word;
            }
        }
        return longestWord;
    }
    public static boolean compareDicOrder(String src, String dest){
        for(int i=0;i<src.length();i++){
            if(src.charAt(i)==dest.charAt(i)) continue;
            else if(src.charAt(i)<dest.charAt(i)) return false;
            else return true;
        }
        return true;
    }*/

    class TrieNode{
        public char data;
        public boolean isword = false;
        public TrieNode[] next = new TrieNode[26];
        public TrieNode(char c){
            data = c;
        }
    }

    class Trie{
        TrieNode root = new TrieNode('/');

        public void insert(String string){             //用来插入一个string
            char[] arr = string.toCharArray();
            TrieNode p = root;
            for(int i=0; i<arr.length; i++){
                int index = arr[i] - 'a';
                if(p.next[index] == null){
                    TrieNode trienode = new TrieNode(arr[i]);
                    p.next[index] = trienode;
                }
                p = p.next[index];
            }
            p.isword = true;
        }

        public boolean isBuild(String string){            //用来判断这个字符串是不是由其他节点依次加一个字符组成
            char[] arr = string.toCharArray();
            TrieNode p = root;
            for(int i=0; i<arr.length; i++){
                if(!p.next[arr[i]-'a'].isword) return false;
                p = p.next[arr[i]-'a'];
            }
            return true;
        }

    }

    String stringLongestWord = "";
    int longLen = 0;
    public String longestWord(String[] words) {
        Trie trie = new Trie();

        for(String word: words){                                     //依次插入string
            trie.insert(word);
        }

        for(String word: words){
            if(trie.isBuild(word) && word.length() > longLen){         //遍历后发现有更长的string满足条件，进行替换
                stringLongestWord = word;
                longLen = word.length();
            }else if(trie.isBuild(word) && word.length() == longLen){     //当出现一样长的字符串时，进行比较
                char[] longestchar = stringLongestWord.toCharArray();
                char[] wordchar = word.toCharArray();
                for(int i = 0; i< longLen; i++){
                    if(wordchar[i]-longestchar[i] < 0){
                        stringLongestWord = word;
                        break;
                    }else if(wordchar[i]-longestchar[i] > 0) break;
                }
            }
        }
        return stringLongestWord;

    }
}
