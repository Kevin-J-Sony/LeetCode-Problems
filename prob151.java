public class prob151 {
    public static void main(String[] args) {
        Solution151 sol = new Solution151();
        sol.reverseWords("  hello world  ");
    }
}

class Solution151 {
    public String reverseWords(String s) {
        s = s.trim();
        String[] words = s.split("\\s+");
        String reversed = "";
        for (int i = words.length - 1; i > 0; i--) {
            reversed += words[i] + " ";
        }
        reversed += words[0];
        return reversed;
    }
}