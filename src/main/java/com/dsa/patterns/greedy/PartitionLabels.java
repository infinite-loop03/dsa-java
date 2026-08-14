package com.dsa.patterns.greedy;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

    public static void main(String[] args) {
        PartitionLabels partitionLabels = new PartitionLabels();
        String s = "abcdef";
        System.out.println(partitionLabels.partitionLabels(s));
    }

    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int[] lastIndexArr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            lastIndexArr[s.charAt(i) - 'a'] = i;
        }

        int start = 0;
        int end = lastIndexArr[s.charAt(0) - 'a'];

        for (int i = 0; i < s.length(); i++) {
            int lastIndex = lastIndexArr[s.charAt(i) - 'a'];
            if (i > end) {
                result.add(end - start + 1);
                start = i;
            }
            if (lastIndex > end) {
                end = lastIndex;
            }
        }
        result.add(end - start + 1);

        return result;
    }
}
