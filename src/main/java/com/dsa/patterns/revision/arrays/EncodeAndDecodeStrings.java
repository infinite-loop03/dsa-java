package com.dsa.patterns.revision.arrays;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {

    public static void main(String[] args) {
        EncodeAndDecodeStrings encodeAndDecodeStrings = new EncodeAndDecodeStrings();
        String encoded = encodeAndDecodeStrings.encode(List.of("Hello", "World"));
        System.out.println(encoded);
        System.out.println(encodeAndDecodeStrings.decode(encoded));
    }

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String str : strs) {
            int length = str.length();
            encoded.append(length);
            encoded.append("#");
            encoded.append(str);
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            String word = str.substring(j + 1, j + 1 + length);
            decoded.add(word);
            i = j + 1 + length;
        }
        return decoded;
    }

}
