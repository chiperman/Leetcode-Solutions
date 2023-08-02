// @algorithm @lc id=100330 lang=java 
// @title zuo-xuan-zhuan-zi-fu-chuan-lcof

// @test("abcdefg",2)="cdefgab"

class Solution {
    // 先反转前n个字符，然后反转后面的字符
    // 然后反转整个字符串
    // "abcdefg" , n=2 → "bacdefg" → "bagfedc" → "cdefgab"
    public String reverseLeftWords(String s, int n) {
        char[] ch = s.toCharArray();
        reverseChar(ch, 0, n - 1);
        reverseChar(ch, n, s.length() - 1);
        reverseChar(ch, 0, s.length() - 1);
        return new String(ch);
    }

    public void reverseChar(char[] ch, int start, int end) {
        while (start < end) {
            char tmp = ch[start];
            ch[start] = ch[end];
            ch[end] = tmp;
            start++;
            end--;
        }
    }
}