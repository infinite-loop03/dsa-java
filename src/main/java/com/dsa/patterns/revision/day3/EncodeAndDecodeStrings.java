package com.dsa.patterns.revision.day3;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {

    public static void main(String[] args) {
        EncodeAndDecodeStrings encodeAndDecodeStrings = new EncodeAndDecodeStrings();
        List<String> strs = List.of("Hello", "World");
        String encoded = encodeAndDecodeStrings.encode(strs);
        System.out.println(encoded);
        List<String> decoded = encodeAndDecodeStrings.decode(encoded);
        System.out.println(decoded);
    }

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        strs.forEach(str -> encoded.append(str.length()).append("#").append(str));
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();

        int i = 0;

        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') j++;
            int length = Integer.parseInt(str.substring(i, j));

            String word = str.substring(j + 1, j + length + 1);
            decoded.add(word);
            i = j + length + 1;
        }
        return decoded;
    }
}
