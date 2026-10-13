package com.dsa.patterns.revision.day21;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {

    static void main() {
        EncodeAndDecodeStrings encodeAndDecodeStrings = new EncodeAndDecodeStrings();
        String[] strs = {"Hello", "World"};
        String encoded = encodeAndDecodeStrings.encode(strs);
        System.out.println(encoded);
        List<String> decoded = encodeAndDecodeStrings.decode(encoded);
        System.out.println(decoded);
    }

    public String encode(String[] arr) {
        StringBuilder encoded = new StringBuilder();
        for (String str : arr) {
            encoded.append(str.length()).append("#").append(str);
        }
        return encoded.toString();
    }

    public ArrayList<String> decode(String s) {
        ArrayList<String> decodedStrings = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {
            int j = i;
            while (s.charAt(j) != '#') j++;

            int length = Integer.parseInt(s.substring(i, j));
            String decoded = s.substring(j + 1, j + length + 1);
            decodedStrings.add(decoded);
            i = j + length + 1;
        }
        return decodedStrings;
    }
}
