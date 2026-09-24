package com.dsa.patterns.revision.day7;

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
        StringBuilder sb = new StringBuilder();
        strs.forEach(str -> sb.append(str.length()).append("#").append(str));
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> decodedStrings = new ArrayList<>();

        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') j++;

            int length = Integer.parseInt(str.substring(i, j));
            String decoded = str.substring(j + 1, j + length + 1);
            decodedStrings.add(decoded);
            i = j + length + 1;
        }
        return decodedStrings;
    }
}
