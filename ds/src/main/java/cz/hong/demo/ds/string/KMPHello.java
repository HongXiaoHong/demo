package cz.hong.demo.ds.string;

import java.util.Arrays;

public class KMPHello {
    private static void getNext(int[] next, String s) {
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(j) != s.charAt(i))
                // 匹配到后缀当前位置的时候, 不匹配
                // 例如现在后缀跟前缀已经匹配到 aaaa aaaa i指向的字母是f j指向的字母是h
                // 回退的时候, 会把后缀匹配部分砍掉, 然后从前缀的最长匹配再次开始匹配
                // 上面的 aaaa 会从 aa 重新开始匹配, 不行再砍...
                j = next[j - 1];

            if (s.charAt(j) == s.charAt(i))
                j++;
            next[i] = j;
        }
    }

    public static void main(String[] args) {
        String needle = "abcabeabfabe";
//        String needle = "ababfabab";
        int[] next = new int[needle.length()];
        getNext(next, needle);
        System.out.printf("next : %s%n", Arrays.toString(next));
    }
}
/*
abababa
next : [0, 0, 1, 2, 3, 4, 5]
 */