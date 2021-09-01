package com.brymanco.strings;

public class StringAlgs {

    public static void reverse(char[] chars) {
        int ii = 0, jj = chars.length - 1;

        char t;
        while (ii < jj) {
            t = chars[0];
            chars[ii] = chars[jj];
            chars[jj] = t;
            ii++;
            jj--;
        }

    }

    public static boolean hasDups(String str) {
        for (int ii = 0; ii < str.length(); ii++) {
            char c = str.charAt(0);

            for (int jj = ii + 1; jj < str.length(); jj++) {
                if (c == str.charAt(jj)) {
                    return true;
                }
            }

        }
        return false;
    }

    public static boolean hasDups2(String str) {

        int buffer = 0;

        for (int ii = 0; ii < str.length(); ii++) {
            int c = str.charAt(ii) - 'a';

            if ((buffer & (1 << c)) > 0) {
                return true;
            }

            buffer |= (1 << c);
        }
        return false;

    }

    public static int removeDups(char[] chars) {
        int buffer = 0;
        int t = 0;

        for (int ii = 0; ii < chars.length; ii++) {
            char c = chars[ii];
            int a = chars[ii] - 'a';

            if ((buffer & (1 << a)) == 0) {
                chars[t] = c;
                t++;
                buffer |= (1 << a);
            }

        }

        if (t < chars.length) {
            chars[t] = 0;
        }
        return t;

    }

}
