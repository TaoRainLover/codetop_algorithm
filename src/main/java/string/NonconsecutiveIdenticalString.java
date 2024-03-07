package string;

/**
 * @author: Tao
 * @Date: 2024/03/07 20:16
 * @Description: 不连续相同字符串
 */

public class NonconsecutiveIdenticalString {
    int res = 0;
    public int minModifyCount(String s) {
        int len = s.length();
        if (len == 0) return 0;
        for (int i = 0; i < len; ) {
            int j = i;
            while(j < s.length() && s.charAt(j) == s.charAt(i)) j++;
            if (j - i > 1) {
                res += (j-i)/2;
            }
            i = j;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "1112222333";
        NonconsecutiveIdenticalString instance = new NonconsecutiveIdenticalString();
        System.out.println(instance.minModifyCount("123456"));
    }
}
