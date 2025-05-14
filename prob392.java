public class prob392 {
    public static void main(String[] args) {
        Solution392 sol = new Solution392();
        sol.isSubsequence("abc", "ahbgdc");
    }
}


class Solution392 {
    public boolean isSubsequence(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        if (slen > tlen) {
            return false;
        }

        int sidx = 0;
        int tidx = 0;
        while (sidx < slen && tidx < tlen) {
            if (t.charAt(tidx) == s.charAt(sidx)) {
                sidx++;
            }
            tidx++;
        }

        return sidx == slen;
    }
}