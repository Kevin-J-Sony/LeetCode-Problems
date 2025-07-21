public class prob125 {
    public static void main(String[] args) {
        Solution125 sol = new Solution125();
        sol.isPalindrome("A man, a plan, a canal: Panama");
    }
}

class Solution125 {

    public boolean isCharOrDigit(char c) {
        return (c  >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }

    public boolean isPalindrome(String s) {
        char[] cray = s.toLowerCase().toCharArray();

        int left_ptr = 0;
        int right_ptr = cray.length - 1;
        while (left_ptr < right_ptr) {
            while (left_ptr < cray.length && !isCharOrDigit(cray[left_ptr])) {
                left_ptr++;
            }
            while (right_ptr >= 0 && !isCharOrDigit(cray[right_ptr])) {
                right_ptr--;
            }
            
            if (left_ptr < s.length() && right_ptr >= 0 && (cray[left_ptr] != cray[right_ptr]))
                return false;
            left_ptr++;
            right_ptr--;
        }
        return true;
    }
}