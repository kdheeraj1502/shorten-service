package com.example.demo.utility;

import lombok.experimental.UtilityClass;

import java.math.BigInteger;

@UtilityClass
public class Base62Convertor {
    private static final String BASE62_CHARS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
// 7037765610431840256
    public static String toBase62(long input) {
        StringBuilder sb = new StringBuilder();
        while(input > 0) {
            sb.append(BASE62_CHARS.charAt((int)(input % 62)));
            input /= 62;
        }
        return sb.reverse().toString();
    }

    public static long fromBase62(final String base62) {
        long result = 0;
        for(int i = 0; i < base62.length(); i++) {
            char c = base62.charAt(i);
            result = result * 62 + BASE62_CHARS.indexOf(c);
        }
        return result;
    }
}
