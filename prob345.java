public class prob345 {
    public static void main(String[] args) {
        Solution345 sol = new Solution345();
        System.out.println(sol.reverseVowels("Hello World"));
    }
}

class Solution345 {
    public boolean isNotVowel(char l) {
        boolean f = (l != 'a' && l != 'e' && l != 'i' && l != 'o' && l != 'u');
        boolean s = (l != 'A' && l != 'E' && l != 'I' && l != 'O' && l != 'U');
        return f && s;
    }
    public String reverseVowels(String s) {
        char[] str = s.toCharArray();
        int leftptr = 0;
        int rightptr = s.length() - 1;

        while (leftptr < rightptr) {
            while (isNotVowel(str[leftptr++]));
            while (isNotVowel(str[rightptr--]));
            leftptr--;
            rightptr++;

            if (leftptr < rightptr) {
                char temp = str[leftptr];
                str[leftptr] = str[rightptr];
                str[rightptr] = temp;
            }
            leftptr++;
            rightptr--;
        }
        return new String(str);
    }
}