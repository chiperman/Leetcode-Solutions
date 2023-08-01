// @algorithm @lc id=100280 lang=java 
// @title ti-huan-kong-ge-lcof

// @test("We are happy")="We%20are%20happy"

class Solution {
    public String replaceSpace(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}

class Solution2 {
    public String replaceSpace(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int index = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[index++] = '%';
                array[index++] = '2';
                array[index++] = '0';
            } else {
                array[index++] = c;
            }
        }
        String newString = new String(array, 0, index);
        return newString;
    }
}

class Solution3 {
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        char[] ch = s.toCharArray();
        int count = 0;
        // 统计空格数量
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == ' ') {
                count++;
            }
        }

        // 本来要把 空格 替换为 %20,所以在原有的基础上多出 20 这两个字符，所以 + count*2;
        char[] ch2 = new char[ch.length + count * 2];
        int l = ch.length - 1;
        int r = ch2.length - 1;

        for (int i = 0; i < ch.length; i++) {
            if (ch[l] == ' ') {
                ch2[r] = '0';
                ch2[r - 1] = '2';
                ch2[r - 2] = '%';
                l--;
                r -= 3;
            } else {
                ch2[r] = ch[l];
                l--;
                r--;
            }

        }
        return new String(ch2);
    }
}